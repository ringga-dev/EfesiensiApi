package com.ngga_ring.efesiensiapi.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.ngga_ring.efesiensiapi.db.confert.ContractDataConverters
import com.ngga_ring.efesiensiapi.db.confert.CostConverters
import com.ngga_ring.efesiensiapi.db.confert.StringConverters
import com.ngga_ring.efesiensiapi.db.confert.TokenInfoConverters

@Entity
@TypeConverters(
    ContractDataConverters::class,
    StringConverters::class,
    TokenInfoConverters::class,
    CostConverters::class,
)
data class DataModels(
    @PrimaryKey(autoGenerate = true) val uid: Long,
    @SerializedName("block") var block: String? = null,
    @SerializedName("hash") var hash: String? = null,
    @SerializedName("timestamp") var timestamp: String? = null,
    @SerializedName("ownerAddress") var ownerAddress: String? = null,
    @SerializedName("toAddressList") var toAddressList: ArrayList<String> = arrayListOf(),
    @SerializedName("toAddress") var toAddress: String? = null,
    @SerializedName("contractType") var contractType: Int? = null,
    @SerializedName("confirmed") var confirmed: Boolean? = null,
    @SerializedName("revert") var revert: Boolean? = null,
    @SerializedName("contractData") var contractData: ContractData? = ContractData(),
    @SerializedName("SmartCalls") var SmartCalls: String? = null,
    @SerializedName("Events") var Events: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("data") var data: String? = null,
    @SerializedName("fee") var fee: String? = null,
    @SerializedName("contractRet") var contractRet: String? = null,
    @SerializedName("result") var result: String? = null,
    @SerializedName("amount") var amount: String? = null,
    @SerializedName("cheatStatus") var cheatStatus: Boolean? = null,
    @SerializedName("cost") var cost: Cost? = Cost(),
    @SerializedName("tokenInfo") var tokenInfo: TokenInfo? = TokenInfo(),
    @SerializedName("tokenType") var tokenType: String? = null,
    @SerializedName("riskTransaction") var riskTransaction: Boolean? = null
)

data class ContractData(
    @SerializedName("amount") var amount: String? = null,
    @SerializedName("owner_address") var ownerAddress: String? = null,
    @SerializedName("to_address") var toAddress: String? = null
)

data class Cost(
    @SerializedName("net_fee") var netFee: String? = null,
    @SerializedName("energy_penalty_total") var energyPenaltyTotal: String? = null,
    @SerializedName("energy_usage") var energyUsage: String? = null,
    @SerializedName("fee") var fee: String? = null,
    @SerializedName("energy_fee") var energyFee: String? = null,
    @SerializedName("energy_usage_total") var energyUsageTotal: String? = null,
    @SerializedName("origin_energy_usage") var originEnergyUsage: String? = null,
    @SerializedName("net_usage") var netUsage: String? = null
)


data class TokenInfo(
    @SerializedName("tokenId") var tokenId: String? = null,
    @SerializedName("tokenAbbr") var tokenAbbr: String? = null,
    @SerializedName("tokenName") var tokenName: String? = null,
    @SerializedName("tokenDecimal") var tokenDecimal: Int? = null,
    @SerializedName("tokenCanShow") var tokenCanShow: Int? = null,
    @SerializedName("tokenType") var tokenType: String? = null,
    @SerializedName("tokenLogo") var tokenLogo: String? = null,
    @SerializedName("tokenLevel") var tokenLevel: String? = null,
    @SerializedName("vip") var vip: Boolean? = null
)


