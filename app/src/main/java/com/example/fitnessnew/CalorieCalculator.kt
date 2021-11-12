package com.example.fitnessnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.view.View
import kotlinx.android.synthetic.main.activity_calorie_calculator.*

class CalorieCalculator : AppCompatActivity() {

    lateinit var a: TextView    // variable cant be null
    lateinit var b: TextView    //textview variables store what the user inputs
    lateinit var c: TextView
    lateinit var d: TextView
    lateinit var e: TextView
    lateinit var f: TextView
    lateinit var p: EditText   //edittext variables output to user
    lateinit var q: EditText
    lateinit var r: EditText
    lateinit var s: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calorie_calculator)  //imports calorie calculator xml for layout


        var btn = findViewById<Button>(R.id.calculate_btn)   //button declared and linking local button to button from xml

        a = findViewById(R.id.cal_maintain) //linking all the text boxes to local variables
        b = findViewById(R.id.cal_bulk)
        c = findViewById(R.id.cal_cut)
        d = findViewById(R.id.mac_protein)
        e = findViewById(R.id.mac_carb)
        f = findViewById(R.id.mac_fat)
        p = findViewById(R.id.editAge)
        q = findViewById(R.id.editHeight)
        r = findViewById(R.id.editWeight)
        s = findViewById(R.id.editGender)



        btn.setOnClickListener(View.OnClickListener {
            var gender : String = s.text.toString()
            if (gender == "M")
                male()
            else if (gender == "F")
                female()
            else
                noUse()



        })


    }

    fun noUse() {
        a.setText(null)
        b.setText(null)
        c.setText(null)
        d.setText(null)
        e.setText(null)
        f.setText(null)


    }

    fun female() {   // runs this if the user is female
        var weight1 = r.text.toString().toDouble()  //stores user input and converts to double
        var height1 = q.text.toString().toDouble()
        var age1 = p.text.toString().toDouble()
        var bulk: Double;  // decalraing variables with datatype
        var cut: Double;
        var protein: Double
        var carbs: Double;
        var fat: Double


        //formulas
        var f1: Double = 10 * weight1
        var f2: Double = 6.25 * height1
        var f3: Double = 5 * age1
        var f4: Double = f1 + f2 - f3
        var bmr: Double = 1.375 * (f4 - 161)


        a.text = bmr.toInt().toString()
        bulk = bmr + 400
        b.text = bulk.toInt().toString()
        cut = bmr - 400
        c.text = cut.toInt().toString()
        protein = (bmr * 0.45)
        protein /= 4
        d.text = protein.toInt().toString()
        carbs = (bmr * 0.3)
        carbs /= 4
        e.text = carbs.toInt().toString()
        fat = (bmr * 0.25)
        fat /= 9
        f.text = fat.toInt().toString()
    }

    fun male() {  // runs if user is a male
        var weight1 = r.text.toString().toDouble()  //declaring userinput and converting to double
        var height1 = q.text.toString().toDouble()
        var age1 = p.text.toString().toDouble()
        var bulk: Double;  //declaring variable with data type
        var cut: Double;
        var protein: Double
        var carbs: Double;
        var fat: Double

        //formulas
        var f1: Double = 10 * weight1
        var f2: Double = 6.25 * height1
        var f3: Double = 5 * age1
        var f4: Double = f1 + f2 - f3
        var bmr: Double = 1.375 * (f4 + 5)

        a.text = bmr.toInt().toString()
        bulk = bmr + 500
        b.text = bulk.toInt().toString()
        cut = bmr - 500
        c.text = cut.toInt().toString()
        protein = (bmr * 0.45)
        protein /= 4
        d.text = protein.toInt().toString()
        carbs = (bmr * 0.3)
        carbs /= 4
        e.text = carbs.toInt().toString()
        fat = (bmr * 0.25)
        fat /= 9
        f.text = fat.toInt().toString()


    }

}
