package com.karoliinamultas.tiistai2501

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.karoliinamultas.tiistai2501.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var on = false
    val parties = MemberOfParliament.ParliamentMembersData.members.map { it.party }.toSet().sorted()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var member = MemberOfParliament.ParliamentMembersData.members

/*        var memberMap: MutableMap<Int, String> = mutableMapOf()
        for(i in 0..member.size.minus(1)){
            memberMap.put(member[i].personNumber, member[i].party)
        }*/


        binding.partiesText.text = parties.toString()

        binding.button.setOnClickListener {
                findRandomPolitician(it)
            }

        }

    fun findRandomPolitician(viewThatIsClicked: View) {
        val input = binding.politicianName.text
        if((parties.any{ it.equals(input) })){
            val politician = MemberOfParliament.ParliamentMembersData.members.map { it.last }.toSet().sorted().toString()
            val randomPolitician = politician.random()
            binding.politicianName.text = randomPolitician.toString()
        }
    }

    }
