package com.gtappdevelopers.bottomsheetexample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.*


class MainActivity : AppCompatActivity(), onLanguageClickListner {
    lateinit var lngRV: RecyclerView
    lateinit var languageRVModalArrayList: ArrayList<LanguageRVModal>
    lateinit var languageRVAdapter: LanguageRVAdapter
    lateinit var parentRL: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lngRV = findViewById(R.id.idRVLanguages)
        parentRL = findViewById(R.id.idRLParent)
        languageRVModalArrayList = ArrayList()
        val layoutManager = GridLayoutManager(this, 2)
        lngRV.layoutManager = layoutManager
        languageRVAdapter = LanguageRVAdapter(languageRVModalArrayList, this)
        lngRV.adapter = languageRVAdapter
        addDataToList()
        languageRVAdapter.notifyDataSetChanged()

    }

    private fun addDataToList() {
        languageRVModalArrayList.add(
            LanguageRVModal(
                "Python",
                R.drawable.python,
                "Beginner",
                "Web, Desktop",
                "https://www.geeksforgeeks.org/python-programming-language/",
                "Python is a high-level, general-purpose and a very popular programming language. Python programming language (latest Python 3) is being used in web development, Machine Learning applications, along with all cutting edge technology in Software Industry. Python Programming Language is very well suited for Beginners, also for experienced programmers with other programming languages like C++ and Java."
            )
        )
        languageRVModalArrayList.add(
            LanguageRVModal(
                "JavaScript",
                R.drawable.js,
                "Beginner",
                "Web, Desktop, Frontend scripting",
                "https://www.geeksforgeeks.org/javascript/",
                "JavaScript is the world most popular lightweight, interpreted compiled programming language. It is also known as scripting language for web pages. It is well-known for the development of web pages, many non-browser environments also use it. JavaScript can be used for Client-side developments as well as Server-side developments."
            )
        )
        languageRVModalArrayList.add(
            LanguageRVModal(
                "Java",
                R.drawable.java,
                "Intermediate",
                "Spring, Hibernate, Strut",
                "https://www.geeksforgeeks.org/java/",
                "Java is one of the most popular and widely used programming languages.\n" +
                        "\n" +
                        "Java has been one of the most popular programming languages for many years.\n" +
                        "Java is Object Oriented. However, it is not considered as pure object-oriented as it provides support for primitive data types (like int, char, etc)\n" +
                        "The Java codes are first compiled into byte code (machine-independent code). Then the byte code runs on Java Virtual Machine (JVM) regardless of the underlying architecture."
            )
        )
        languageRVModalArrayList.add(
            LanguageRVModal(
                "C++",
                R.drawable.c,
                "Beginner to Intermediate",
                "Mobile, Desktop, Embedded",
                "https://www.geeksforgeeks.org/c-plus-plus/",
                "C++ is a general-purpose programming language and is widely used nowadays for competitive programming. It has imperative, object-oriented and generic programming features. C++ runs on lots of platforms like Windows, Linux, Unix, Mac etc.\n"
            )
        )
        languageRVModalArrayList.add(
            LanguageRVModal(
                "Swift",
                R.drawable.swift,
                "Beginner",
                "Mobile (Apple iOS apps, specifically)",
                "https://www.geeksforgeeks.org/swift-programming-language/",
                "Swift is a general-purpose, multi-paradigm, object-oriented, functional, imperative and block-structured language. Swift is the result of the latest research on programming languages and is built using a modern approach to safety, software design patterns by Apple Inc. for iOS applications, macOS applications, watchOS applications, tvOS applications. \n"
            )
        )
        languageRVModalArrayList.add(
            LanguageRVModal(
                "HTML",
                R.drawable.html,
                "Beginner",
                "Frontend",
                "https://www.geeksforgeeks.org/html/",
                "HTML stands for HyperText Markup Language. It is used to design web pages using the markup language. HTML is the combination of Hypertext and Markup language. Hypertext defines the link between the web pages and markup language defines the text document within the tag that define the structure of web pages.\n" +
                        "\n"
            )
        )
        languageRVModalArrayList.add(
            LanguageRVModal(
                "PHP",
                R.drawable.php,
                "Beginner",
                "Cross-platform (desktop, mobile, web) Back-end web scripting.",
                "https://www.geeksforgeeks.org/php-tutorials/",
                "The term PHP is an acronym for Hypertext Preprocessor. It is a server-side scripting language that is used for web development. It can be easily embedded with HTML files. HTML codes can also be written in a PHP file. The PHP codes are executed on the server-side whereas HTML codes are directly executed on the browser.\n" +
                        "\n"
            )
        )
        languageRVModalArrayList.add(
            LanguageRVModal(
                "C#",
                R.drawable.csharp,
                "Intermediate",
                "Cross-platform, including mobile and enterprise software applications",
                "https://www.geeksforgeeks.org/csharp-programming-language/",
                "C# is a general-purpose, modern and object-oriented programming language pronounced as “C Sharp”. It was developed by Microsoft led by Anders Hejlsberg and his team within the .NET initiative and was approved by the European Computer Manufacturers Association (ECMA) and International Standards Organization (ISO). C# is among the languages for Common Language Infrastructure. C# is a lot similar to Java syntactically and is easy for users who have knowledge of C, C++ or Java.\n" +
                        "\n"
            )
        )
        languageRVModalArrayList.add(
            LanguageRVModal(
                "CSS",
                R.drawable.css,
                "Beginner",
                "Frontend",
                "https://www.geeksforgeeks.org/css/",
                "CSS (Cascading Style Sheets) is a stylesheet language used to design a webpage to make it attractive. The reason for using this is to simplify the process of making web pages presentable. It allows you to apply styles on web pages. More importantly, it enables you to do this independent of the HTML that makes up each web page.\n" +
                        "\n"
            )
        )
    }

    override fun onClick(position: Int) {

        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog)
        bottomSheetDialog.setCancelable(false)
        bottomSheetDialog.setCanceledOnTouchOutside(true)
        bottomSheetDialog.show()

        val lngNameTV: TextView = bottomSheetDialog.findViewById(R.id.idTVLanguage)!!
        val lngLevelTV: TextView = bottomSheetDialog.findViewById(R.id.idTVLanguageLevel)!!
        val lngPlatformTV: TextView = bottomSheetDialog.findViewById(R.id.idTVLanguagePlatform)!!
        val lngDescTV: TextView = bottomSheetDialog.findViewById(R.id.idTVLanguageDescription)!!
        val lngIV: ImageView = bottomSheetDialog.findViewById(R.id.idIVLanguage)!!
        val viewLngDetailsBtn: Button = bottomSheetDialog.findViewById(R.id.idBtnViewDetails)!!

        viewLngDetailsBtn.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(languageRVModalArrayList[position].lngUrl)
            startActivity(i)
        }
        lngNameTV.text = languageRVModalArrayList.get(position).languageName
        lngLevelTV.text = "Level : " + languageRVModalArrayList.get(position).lngLevel
        lngPlatformTV.text =
            "Language Platform : " + languageRVModalArrayList.get(position).languageName
        lngDescTV.text = "Description : \n" + languageRVModalArrayList.get(position).lngDesc
        lngIV.setImageResource(languageRVModalArrayList.get(position).lngImg)
    }

}