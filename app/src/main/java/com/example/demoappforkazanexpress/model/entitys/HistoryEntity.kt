import com.google.gson.annotations.SerializedName

data class HistoryEntity(
    @SerializedName("entry") val entry: String,
    @SerializedName("balance") val balance: String,
    @SerializedName("currency") val currency: String,
    @SerializedName("sender") val sender: String,
    @SerializedName("recipient") val recipient: String
)