package com.example.comics.core.data.remote.response

import com.example.comics.core.data.remote.model.ResultModel
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

data class ItemModel(
    @SerializedName("data")
    val data: DataModel
) : Flow<ItemModel> {
    override suspend fun collect(collector: FlowCollector<ItemModel>) {
        collector.emit(this)
    }
}

data class DataModel(
    @SerializedName("results")
    val results: List<ResultModel>
)