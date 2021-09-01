import com.google.gson.annotations.SerializedName

data class WalletsEntity (
	@SerializedName("wallet_name") val walletName : String,
	@SerializedName("balance") val balance : String
)