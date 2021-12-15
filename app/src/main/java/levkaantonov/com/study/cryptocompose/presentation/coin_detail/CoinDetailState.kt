package levkaantonov.com.study.cryptocompose.presentation.coin_detail

import levkaantonov.com.study.cryptocompose.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)