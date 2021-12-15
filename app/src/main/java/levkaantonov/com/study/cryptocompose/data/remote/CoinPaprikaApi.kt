package levkaantonov.com.study.cryptocompose.data.remote

import levkaantonov.com.study.cryptocompose.data.remote.dto.CoinDetailDto
import levkaantonov.com.study.cryptocompose.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun loadCoins(): List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}