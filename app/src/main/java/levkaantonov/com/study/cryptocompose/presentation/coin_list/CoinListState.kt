package levkaantonov.com.study.cryptocompose.presentation.coin_list

import levkaantonov.com.study.cryptocompose.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)