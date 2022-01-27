package com.karoliinamultas.tiistai2501

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.karoliinamultas.tiistai2501.MemberOfParliament.ParliamentMembersData.members
import com.karoliinamultas.tiistai2501.databinding.ActivityMainBinding
import kotlin.math.log


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val parties = members.map { it.party }.toSet().sorted()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.partiesText.text = parties.toString()

        fun findRandomPolitician(view: View) {

            val input = binding.userInput.text.toString()
            if (parties.any { it.equals(input)}) {

                val allMembersFromSameParty = members.filter { member ->
                    member.party.contains(input)
                }
                val randMember = allMembersFromSameParty.random()

                binding.politicianName.text = randMember.first + " " + randMember.last + " " + randMember.party

            }
            else binding.politicianName.text = "Try again."
        }
        binding.button.setOnClickListener {
            findRandomPolitician(it)
        }

    }

}


