package com.example.androiddevhw_2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.github.barteksc.pdfviewer.PDFView

class PdfViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_view)

        findViewById<Button>(R.id.openPdfBtn)?.setOnClickListener{
           val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.africau.edu/images/default/sample.pdf"))
           startActivity(intent)
       }

        //findViewById<PDFView>(R.id.pdfView).fromAsset("test.pdf").load()
    }
}