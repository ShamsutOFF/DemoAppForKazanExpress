package com.example.demoappforkazanexpress.model.entitys

import HistoryEntity
import com.google.gson.annotations.SerializedName

data class BaseHistoriesEntity (
	@SerializedName("histories") val histories : List<HistoryEntity>
)