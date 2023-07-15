package com.ngga_ring.efesiensiapi.models

import com.google.gson.annotations.SerializedName


data class BaseModels<T>(
    @SerializedName("total") var total: Int? = null,
    @SerializedName("rangeTotal") var rangeTotal: Int? = null,
    @SerializedName("data") var data: T? = null,
    @SerializedName("wholeChainTxCount") var wholeChainTxCount: String? = null,
    @SerializedName("contractMap") var contractMap: Any? = null,
    @SerializedName("contractInfo") var contractInfo: Any? = null,
    @SerializedName("normalAddressInfo") var normalAddressInfo: Any? = null,
)


