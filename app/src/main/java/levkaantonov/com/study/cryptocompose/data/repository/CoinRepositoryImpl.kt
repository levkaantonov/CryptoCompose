package levkaantonov.com.study.cryptocompose.data.repository

import levkaantonov.com.study.cryptocompose.data.remote.CoinPaprikaApi
import levkaantonov.com.study.cryptocompose.data.remote.dto.CoinDetailDto
import levkaantonov.com.study.cryptocompose.data.remote.dto.CoinDto
import levkaantonov.com.study.cryptocompose.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun loadCoins(): List<CoinDto> {
        return api.loadCoins()
    }

    override suspend fun getCoinById(id: String): CoinDetailDto {
        return api.getCoinById(id)
    }
}