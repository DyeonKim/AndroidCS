package com.example.androidcs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcs.data.Person
import com.example.androidcs.data.getFullName

class PersonsAdapter(private val dataSet: List<Person>) :
    RecyclerView.Adapter<PersonsAdapter.PersonsViewHolder>() {
    private lateinit var itemClickListener: ItemClickListener

    inner class PersonsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvName: TextView
        private val tvAge: TextView
        private val tvGender: TextView

        init {
            tvName = view.findViewById(R.id.list_tv_name)
            tvAge = view.findViewById(R.id.list_tv_age)
            tvGender = view.findViewById(R.id.list_tv_gender)
        }

        fun bindInfo(data: Person) {
            tvName.text = data.getFullName()
            tvAge.text = data.age.toString()
            tvGender.text = data.gender
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonsViewHolder {
        // 리스트 아이템 UI를 정의한 뷰 생성
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_person_item, parent, false)
        return PersonsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonsViewHolder, position: Int) {
        holder.apply {
            bindInfo(dataSet[position])
            itemView.setOnClickListener {
                itemClickListener.onClick(dataSet[position])
            }
        }
    }

    override fun getItemCount(): Int = dataSet.size

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    interface ItemClickListener {
        fun onClick(person: Person)
    }
}