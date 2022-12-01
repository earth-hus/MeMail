package com.example.memail;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.*;

public class HomeActivity extends AppCompatActivity {
    Button b;
    Button b1;
    Button b2;

    Button signOutButton;
    FirebaseAuth mAuth;

    ImageButton savedButton;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        b = findViewById(R.id.schoolButton);
        b1 = findViewById(R.id.professionButton);
        b2 = findViewById(R.id.organizationButton);

        b.setOnClickListener(this::onClick);
        b1.setOnClickListener(this::onClick);
        b2.setOnClickListener(this::onClick);

        mAuth = FirebaseAuth.getInstance();

        signOutButton = findViewById(R.id.SignOut);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(HomeActivity.this, LogInKT.class);
                startActivity(intent);
            }
        });

//---------------------------------------------------------------------------------------------
        //  School
        CollectionReference templates = db.collection("Templates");
        Map<String, Object> data1 = new HashMap<>();
        data1.put("Category", "School");
        data1.put("Draft", "Hi [Professor/Dr.] [Name of Instuctor's Last Name]\n" +
                "\n" +
                "I hope all is well! \n" +
                "\n" +
                "I am in your [course name] this [fall/spring/summer/winter]. Unfortantley, I will not be in class this week due to [\"personal circumstance\"/\"family wedding\"]. \n" +
                "\n" +
                "I wanted to let you know in advance of my absence in class. What are some assignments or work I need to do to stay caught up witht the class.\n" +
                "\n" +
                "Best,\n" +
                "[student name]");

        data1.put("Title", "Draft");
        data1.put("Format", "Default Draft");
        data1.put("Topic", "Absence");
        templates.document("s1").set(data1);

        savedButton = findViewById(R.id.savedButton);
        savedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SavedActivity.class);
                HomeActivity.this.startActivity(intent);
            }
        });

        Map<String, Object> data2 = new HashMap<>();
        data2.put("Category", "School");
        data2.put("Draft", "Hi [Professor/Dr.] [Name of Instuctor's Last Name]\n" +
                "\n" +
                "I hope all is well! \n" +
                "\n" +
                "I am a [year you are in school] majoring in [name of your major]. I am in your [course name] this [fall/spring/summer/winter].\n" +
                "\n" +
                "I'm very excited to learn and excel in your course! [can state you interests in the course.] See you [day of class]!\n" +
                "\n" +
                "Best,\n" +
                "[student name]");
        data2.put("Title", "Draft");
        data2.put("Format", "Default Draft");
        data2.put("Topic", "Introduction");
        templates.document("s2").set(data2);


        Map<String, Object> data3 = new HashMap<>();
        data3.put("Category", "School");
        data3.put("Draft","Dear [Professor/Dr.] [Name of Professors' Last Name], \n" +
                "\n" +
                "My name is [full name] and I am a [your year] in your [day of your classes] [course name of class] Class. I am writing because in enjoy [subject of the class]. I've read some of your papers, and found your research projects very interesting. I would like to learn more and possibly talk to you about joining the lab. Is there a time in the coming weeks that we could meet? \n" +
                "\n" +
                "I am availble at these times:\n" +
                "\n" +
                "[Give a few different dates with different time slots you are avialble\n" +
                "\n" +
                "Example:\n" +
                "Monday: 2-4pm CST\n" +
                "Tuesday: 12pm-2pm CST & after 3pm CST\n" +
                "\n" +
                "]\n" +
                "\n" +
                "\n" +
                "\n" +
                "Thank you for your time and I look forward to hearing from you soon! \n" +
                "\n" +
                "\n" +
                "\n" +
                "Best regards, \n" +
                "[student name] \n" +
                "[course name], Class of [year you graduate]");
        data3.put("Title", "Draft");
        data3.put("Format", "Default Draft");
        data3.put("Topic", "Research Interest");
        templates.document("s3").set(data3);


        Map<String, Object> data4 = new HashMap<>();
        data4.put("Category", "School");
        data4.put("Draft", "Dear [Professor/Dr.] [Recommender Name],\n" +
                "\n" +
                "I hope you’re well. I’m in the process of applying to [school or company name] and want to ask if you feel comfortable writing a strong letter of recommendation on my behalf.\n" +
                "\n" +
                "I thoroughly enjoyed my time as [your relationship to the recommender]. As my [teacher/counselor/manager], I believe you could honestly and effectively vouch for my [list of skills or qualifications] I’ve demonstrated during our time together. \n" +
                "\n" +
                "I appreciate you considering my request. The deadline for submitting the letter is [date]. I’ve attached an updated version of my [resume/brag sheet], as well as the [job posting/admission requirements] and details on how to submit the letter. If you need any additional information, don’t hesitate to contact me. \n" +
                "\n" +
                "Thank you for your time and support.\n" +
                "\n" +
                "Sincerely,\n" +
                "\n" +
                "[Your Name]\n" +
                "\n" +
                "[Your phone number]");
        data4.put("Title", "Draft");
        data4.put("Format", "Default Draft");
        data4.put("Topic", "Recommendation Letter");
        templates.document("s4").set(data4);

//---------------------------------------------------------------------------------------------
        // Profession
        Map<String, Object> data5 = new HashMap<>();
        data5.put("Category", "Profession");
        data5.put("Draft", "\"Dear [Recruiter name],\n" +
                "\n" +
                "I appreciate you and your team taking the time to meet with me to discuss the opportunity for employment for the [name of the job role]. After careful thought and consideration, I decided to accept another position that was a better fit for me at this time. However, I remain very interested in your company and the work that you do and would welcome the potential for future opportunities.\n" +
                "\n" +
                "Thank you for your time and consideration.\n" +
                "\n" +
                "Sincerely,\n" +
                "\n" +
                "[Your Name]\"");
        data5.put("Title", "Draft");
        data5.put("Format", "Default Draft");
        data5.put("Topic", "Decline Offer");
        templates.document("p1").set(data5);


        Map<String, Object> data6 = new HashMap<>();
        data6.put("Category", "Profession");
        data6.put("Draft", "Dear [Recruiter Name],\n" +
                "\n" +
                "Thank you for selecting me as a candidate for the [name of job role] position at [name of company]. I am pleased to inform you that I am accepting this position and excited to start. Thank you again for the opportunity, I am eager to make a positive contribution to the organization. Please let me know if there is any additional information or paperwork you need.\n" +
                "\n" +
                "Best,\n" +
                "\n" +
                "[Your Name]");
        data6.put("Title", "Draft");
        data6.put("Format", "Default Draft");
        data6.put("Topic", "Accept Offer");
        templates.document("p2").set(data6);

        Map<String, Object> data7 = new HashMap<>();
        data7.put("Category", "Profession");
        data7.put("Draft", "Dear [Recruiter Name],\n" +
                "\n" +
                "Thank you for offering me a position as a [name of job role postion] for this summer. I enjoyed meeting with the team and really appreciate your emphasis on continual learning at [name of company]. I would like to request an extension for my offer deadline of [original deadline date]. After talking with [Name of Department or college] Career Services, I’ve learned that my university recommends students are given three weeks in order to fully consider an offer and make an informed decision. The university guidelines are listed here: [ input linkhttps://ecs.grainger.illinois.edu/student-resources/offers/guidelines]. \n" +
                "\n" +
                "Would you be able to adhere to my university’s offer deadline guidelines?\n" +
                "\n" +
                "If you would prefer to discuss this over call, I'd be happy to do that as well. I'm available during these times:\n" +
                "\n" +
                "[Give a few different dates with different time slots you are avialble]\n" +
                "\n" +
                "Thank you for your consideration of my request.\n" +
                "\n" +
                "Sincerely,\n" +
                "\n" +
                "Your Name\n" +
                "Phone Number: [include your phone number]\n");
        data7.put("Title", "Draft");
        data7.put("Format", "Default Draft");
        data7.put("Topic", "Extension Request");
        templates.document("p3").set(data7);
//---------------------------------------------------------------------------------------------
        // Organization

        Map<String, Object> data = new HashMap<>();
        data.put("Category", "Profession");
        data.put("Draft", "This is \n a test \n for line \n breaks \n");
        data.put("Title", "Draft");
        data.put("Format", "Default Draft");
        data.put("Topic", "Job Offer Negotiation");
        templates.document("o1").set(data);


//    binding.btnGoogleSignOut.setOnClickListener {
//            firebaseAuth.signOut()
//            googleSignInClient.signOut()
//            onResume()
//
//            Log.d(TAG, "onActivityResult : Sign Out Successfully!")
//            Toast.makeText(this, "Sign Out Successfully!", Toast.LENGTH_SHORT).show()
//        }
//        signOut.setOnClickListener()
    }
    public void onClick(View v) {
        String buttonText = b.getText().toString();
        Intent myIntent = new Intent(HomeActivity.this, TopicActivity.class);
        String category = "";

        if (v.getId() == b.getId()) {
            category = "School";
        } else if (v.getId() == b1.getId()) {
            category = "Profession";
        } else {
            category = "Organization";
        }

        myIntent.putExtra("Category", category);
        HomeActivity.this.startActivity(myIntent);
    }

}