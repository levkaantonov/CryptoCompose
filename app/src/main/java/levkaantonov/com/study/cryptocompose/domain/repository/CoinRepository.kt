package levkaantonov.com.study.cryptocompose.domain.repository

import levkaantonov.com.study.cryptocompose.data.remote.dto.CoinDetailDto
import levkaantonov.com.study.cryptocompose.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun loadCoins(): List<CoinDto>
    suspend fun getCoinById(id: String): CoinDetailDto
}