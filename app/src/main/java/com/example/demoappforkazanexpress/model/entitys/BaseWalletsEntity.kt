package com.example.demoappforkazanexpress.model.entitys

import WalletsEntity
import com.google.gson.annotations.SerializedName

data class BaseWalletsEntity (
	@SerializedName("wallets") val wallets : List<WalletsEntity>
)