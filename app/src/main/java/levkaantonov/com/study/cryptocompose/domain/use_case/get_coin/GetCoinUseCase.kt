package levkaantonov.com.study.cryptocompose.domain.use_case.get_coin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import levkaantonov.com.study.cryptocompose.common.Resource
import levkaantonov.com.study.cryptocompose.data.remote.dto.toCoin
import levkaantonov.com.study.cryptocompose.data.remote.dto.toCoinDetail
import levkaantonov.com.study.cryptocompose.domain.model.Coin
import levkaantonov.com.study.cryptocompose.domain.model.CoinDetail
import levkaantonov.com.study.cryptocompose.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}