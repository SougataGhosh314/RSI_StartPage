package com.example.sougataghosh.startpage;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CardView card1, card2, card3, card4, card5, card6, card7, card8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setExpandedStrings();
        setViews();
        setOnClickListeners();

    }

    private void setOnClickListeners() {
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CardActivity.class);
                startActivity(intent);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Will be available in the future.", Toast.LENGTH_LONG).show();
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Will be available in the future.", Toast.LENGTH_LONG).show();
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Will be available in the future.", Toast.LENGTH_LONG).show();
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Will be available in the future.", Toast.LENGTH_LONG).show();
            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Will be available in the future.", Toast.LENGTH_LONG).show();
            }
        });

        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Will be available in the future.", Toast.LENGTH_LONG).show();
            }
        });

        card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Will be available in the future.", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setViews() {
        card1 = findViewById(R.id.card_1);
        card2 = findViewById(R.id.card_2);
        card3 = findViewById(R.id.card_3);
        card4 = findViewById(R.id.card_4);
        card5 = findViewById(R.id.card_5);
        card6 = findViewById(R.id.card_6);
        card7 = findViewById(R.id.card_7);
        card8 = findViewById(R.id.card_8);
    }

    private void setExpandedStrings() {

        String hisRSI = getResources().getString(R.string.aboutRSAMI);
        ExpandableTextView expandableTextView_1 = (ExpandableTextView) findViewById(R.id.hisRSI_ID);
        expandableTextView_1.setText(hisRSI);

        String affiliations = getResources().getString(R.string.affiliations);
        ExpandableTextView expandableTextView_2 = (ExpandableTextView) findViewById(R.id.affiliations_ID);
        expandableTextView_2.setText(affiliations);

        String membershipRules = getResources().getString(R.string.membershipRules);
        ExpandableTextView expandableTextView_3 = (ExpandableTextView) findViewById(R.id.membershipRules_ID);
        expandableTextView_3.setText(membershipRules);

        String contactUs = getResources().getString(R.string.contactUs);
        ExpandableTextView expandableTextView_4 = (ExpandableTextView) findViewById(R.id.contactUs_ID);
        expandableTextView_4.setText(contactUs);
    }


}

class ExpandableTextView extends android.support.v7.widget.AppCompatTextView {
    private static final int DEFAULT_TRIM_LENGTH = 80;
    private static final String ELLIPSIS = ".....";

    private CharSequence originalText;
    private CharSequence trimmedText;
    private BufferType bufferType;
    private boolean trim = true;
    private int trimLength;

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ExpandableTextView);
        this.trimLength = typedArray.getInt(R.styleable.ExpandableTextView_trimLength, DEFAULT_TRIM_LENGTH);
        typedArray.recycle();

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                trim = !trim;
                setText();
                requestFocusFromTouch();
            }
        });
    }

    private void setText() {
        super.setText(getDisplayableText(), bufferType);
    }

    private CharSequence getDisplayableText() {
        return trim ? trimmedText : originalText;
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        originalText = text;
        trimmedText = getTrimmedText(text);
        bufferType = type;
        setText();
    }

    private CharSequence getTrimmedText(CharSequence text) {
        if (originalText != null && originalText.length() > trimLength) {
            return new SpannableStringBuilder(originalText, 0, trimLength + 1).append(ELLIPSIS);
        } else {
            return originalText;
        }
    }

    public CharSequence getOriginalText() {
        return originalText;
    }

    public void setTrimLength(int trimLength) {
        this.trimLength = trimLength;
        trimmedText = getTrimmedText(originalText);
        setText();
    }

    public int getTrimLength() {
        return trimLength;
    }
}
