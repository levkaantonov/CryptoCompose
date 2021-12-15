package levkaantonov.com.study.cryptocompose.domain.use_case.load_coins

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import levkaantonov.com.study.cryptocompose.common.Resource
import levkaantonov.com.study.cryptocompose.data.remote.dto.toCoin
import levkaantonov.com.study.cryptocompose.domain.model.Coin
import levkaantonov.com.study.cryptocompose.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoadCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.loadCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}