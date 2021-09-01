package com.example.demoappforkazanexpress.model.items

import WalletsEntity
import com.example.demoappforkazanexpress.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_position.*

class WalletsItem(private val wallet: WalletsEntity) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.title_text_view.text = wallet.walletName
        viewHolder.detail_text_view.text = wallet.balance
    }

    override fun getLayout() = R.layout.item_position
}