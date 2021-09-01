package com.example.demoappforkazanexpress.model.items

import HistoryEntity
import com.example.demoappforkazanexpress.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_position.*


class HistoryItem(private val history: HistoryEntity) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.title_text_view.text = "${history.entry} от: ${history.sender}, в пользу: ${history.recipient}"
        viewHolder.detail_text_view.text = "${history.balance} ${history.currency}"
    }

    override fun getLayout() = R.layout.item_position
}