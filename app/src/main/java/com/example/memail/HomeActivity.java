package com.example.memail;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        data1.put("Draft", "Hi [Professor/Dr.] [Name of Instructor's Last Name]\n" +
                "\n" +
                "I hope all is well! \n" +
                "\n" +
                "I am in your [course name] this [fall/spring/summer/winter]. Unfortunately, I will not be in class this week due to [\"personal circumstance\"/\"family wedding\"]. \n" +
                "\n" +
                "I wanted to let you know in advance of my absence in class. What are some assignments or work I need to do to stay caught up witht the class.\n" +
                "\n" +
                "Best,\n" +
                "[student name]");

        data1.put("Title", "Draft");
        data1.put("Format", "Default Draft");
        data1.put("Topic", "Absence");
        templates.document("s1").set(data1);


        Map<String, Object> data2 = new HashMap<>();
        data2.put("Category", "School");
        data2.put("Draft", "Hi [Professor/Dr.] [Name of Instructor's Last Name]\n" +
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
                "I am available at these times:\n" +
                "\n" +
                "[Give a few different dates with different time slots you are availble\n" +
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

        Map<String, Object> data5 = new HashMap<>();
        data5.put("Category", "School");
        data5.put("Draft", "Dear [Professor/Dr.] [Professor's Last Name], \n" +
                "\n" +
                "I hope all is well!\n" +
                "\n" +
                "I'm in your [course name] class and was wodnering if it was possible if I can request an extension for my current assignment? I'm struggling to complete the assignment in time because [insert reasons]. I would like to reassure you that if you grant me this extension, I will ensure I deliver the assignment for this date. Sorry for any inconveionence.\n" +
                "\n" +
                "I appreciate your time and consideration. \n" +
                "\n" +
                "Thank you,\n" +
                "[Your Name]");
        data5.put("Title", "Draft");
        data5.put("Format", "Default Draft");
        data5.put("Topic", "Extension Request");
        templates.document("s5").set(data5);

        Map<String, Object> data6 = new HashMap<>();
        data6.put("Category", "School");
        data6.put("Draft", "Hi [Professor/Dr.] [Name of Instuctor's Last Name]\n" +
                "\n" +
                "I hope all is well! \n" +
                "\n" +
                "I am in your [course name] this [fall/spring/summer/winter]. I was wondering if I could take rescheudle my exam date because [\"personal circumstance\"/\"family wedding\"/ \"out of town\"/ \"was sick\"/ \"had a hard time studying\"]. \n" +
                "\n" +
                "I know this is a lot to ask for and I would really like to sufficiently prepared for the exam. \n" +
                "\n" +
                "I appreciate your time and consideration.\n" +
                "\n" +
                "Thank you,\n" +
                "[student name]");
        data6.put("Title", "Draft");
        data6.put("Format", "Default Draft");
        data6.put("Topic", "Exam Rescheduling");
        templates.document("s6").set(data6);


//---------------------------------------------------------------------------------------------
        // Profession
        Map<String, Object> data7 = new HashMap<>();
        data7.put("Category", "Profession");
        data7.put("Draft", "\"Dear [Recruiter name],\n" +
                "\n" +
                "I appreciate you and your team taking the time to meet with me to discuss the opportunity for employment for the [name of the job role]. After careful thought and consideration, I decided to accept another position that was a better fit for me at this time. However, I remain very interested in your company and the work that you do and would welcome the potential for future opportunities.\n" +
                "\n" +
                "Thank you for your time and consideration.\n" +
                "\n" +
                "Sincerely,\n" +
                "\n" +
                "[Your Name]\"");
        data7.put("Title", "Draft");
        data7.put("Format", "Default Draft");
        data7.put("Topic", "Decline Offer");
        templates.document("p1").set(data7);


        Map<String, Object> data8 = new HashMap<>();
        data8.put("Category", "Profession");
        data8.put("Draft", "Dear [Recruiter Name],\n" +
                "\n" +
                "Thank you for selecting me as a candidate for the [name of job role] position at [name of company]. I am pleased to inform you that I am accepting this position and excited to start. Thank you again for the opportunity, I am eager to make a positive contribution to the organization. Please let me know if there is any additional information or paperwork you need.\n" +
                "\n" +
                "Best,\n" +
                "\n" +
                "[Your Name]");
        data8.put("Title", "Draft");
        data8.put("Format", "Default Draft");
        data8.put("Topic", "Accept Offer");
        templates.document("p2").set(data8);

        Map<String, Object> data9 = new HashMap<>();
        data9.put("Category", "Profession");
        data9.put("Draft", "Dear [Recruiter Name],\n" +
                "\n" +
                "Thank you for offering me a position as a [name of job role position] for this summer. I enjoyed meeting with the team and really appreciate your emphasis on continual learning at [name of company]. I would like to request an extension for my offer deadline of [original deadline date]. After talking with [Name of Department or college] Career Services, I’ve learned that my university recommends students are given three weeks in order to fully consider an offer and make an informed decision. The university guidelines are listed here: [ input linkhttps://ecs.grainger.illinois.edu/student-resources/offers/guidelines]. \n" +
                "\n" +
                "Would you be able to adhere to my university’s offer deadline guidelines?\n" +
                "\n" +
                "If you would prefer to discuss this over call, I'd be happy to do that as well. I'm available during these times:\n" +
                "\n" +
                "[Give a few different dates with different time slots you are available]\n" +
                "\n" +
                "Thank you for your consideration of my request.\n" +
                "\n" +
                "Sincerely,\n" +
                "\n" +
                "Your Name\n" +
                "Phone Number: [include your phone number]\n");
        data9.put("Title", "Draft");
        data9.put("Format", "Default Draft");
        data9.put("Topic", "Extension Request");
        templates.document("p3").set(data9);



        Map<String, Object> data10 = new HashMap<>();
        data10.put("Category", "Profession");
        data10.put("Draft", "Hi [Sender's Name], \n" +
                "\n" +
                "I hope you are doing well!\n" +
                "\n" +
                "I am a [year in school/job position] [at/graduated from [school name]].  I met you at [state how you know them/where you met them].  \n" +
                "\n" +
                "Do you think we can schedule a time for a coffee chat/call this week? I'm interested in applying to [company name] and would like to know more about the position. \n" +
                "\n" +
                "[Give a few different dates with different time slots you are available\n" +
                "\n" +
                "Example:\n" +
                "Monday: 2-4pm CST\n" +
                "Tuesday: 12pm-2pm CST & after 3pm CST\n" +
                "\n" +
                "]\n" +
                "\n" +
                "I appreciate your time and consideration. \n" +
                "\n" +
                "Thank you,\n" +
                "[Your Name]");
        data10.put("Title", "Draft");
        data10.put("Format", "Default Draft");
        data10.put("Topic", "Referral Request");
        templates.document("p4").set(data10);


        Map<String, Object> data11 = new HashMap<>();
        data11.put("Category", "Profession");
        data11.put("Draft", "Hi [Advisor's Name], \n" +
                "\n" +
                "I hope you are doing well!\n" +
                "\n" +
                "I really enjoyed working with the team [during/this past] [state the year/time] and really appreciate the emphasis on continual learning at [company name].\n" +
                "\n" +
                "Because I am applying for a job position, is it possible you can right me a letter of recommendation? I need to have my letter of recommendation submitted by [time you want to have the letter of rec. by]. \n" +
                "\n" +
                "I attached my resume below. I appreciate your time and consideration. Please let me know if yu have any questions or if there is anything I can do to help.\n" +
                "\n" +
                "Thank you,\n" +
                "[Your Name]");
        data11.put("Title", "Draft");
        data11.put("Format", "Default Draft");
        data11.put("Topic", "Letter of Recommendation Request");
        templates.document("p5").set(data11);


        Map<String, Object> data12 = new HashMap<>();
        data12.put("Category", "Profession");
        data12.put("Draft", "Hi [Manager's Name],\n" +
                "\n" +
                "\n" +
                "I'm emailing you to formally resign as [job title] at [company name]. I understand I need to offer two-weeks notice, and I would like to start the process today.\n" +
                "\n" +
                "I would really like to set a time to meet so we can find an ideal leaving date. \n" +
                "\n" +
                "I sincerely appreciate all the guidance and support you have shown me during my time at (company). It's greatly appreciated and has helped to shape my future career. \n" +
                "\n" +
                "[Add personal details here]\n" +
                "\n" +
                "Thanks for everything you've done. I've enjoyed my time at [company name].\n" +
                "\n" +
                "Kindest regards,\n" +
                "\n" +
                "[Your name]\n");
        data12.put("Title", "Draft");
        data12.put("Format", "Default Draft");
        data12.put("Topic", "Letter of Resignation");
        templates.document("p6").set(data12);


        Map<String, Object> data13 = new HashMap<>();
        data13.put("Category", "Profession");
        data13.put("Draft", "Hi [Recruiter's Name], \n" +
                "\n" +
                "I hope all is well!\n" +
                "\n" +
                "Thank you so much for the [Position Title] job offer! I am excited for the chance to work with [Company Name] in this capacity. I really enjoyed meeting all the team. \n" +
                "\n" +
                "Though your company is my first choice, I have received an offer for [other salary offer] from a different organization. Is it possible you could match this figure?\n" +
                "\n" +
                "Again, I am highly interested in this opportunity. I look forward to working with you all at [Company Name]!\n" +
                "\n" +
                "Best, \n" +
                "[Your Name]");
        data13.put("Title", "Draft");
        data13.put("Format", "Default Draft");
        data13.put("Topic", "Job Offer Negotiation");
        templates.document("p7").set(data13);


        Map<String, Object> data14 = new HashMap<>();
        data14.put("Category", "Profession");
        data14.put("Draft", "Hi [Advisor's/Manager's Name], \n" +
                "\n" +
                "I would like to request for one week’s PTO from [Date you will be gone] to [last day you will be gone]. I will be back in the office on [date you will be back in the office].\n" +
                "\n" +
                "All of the projects that I am working on will be completed before I leave. My team has agreed to cover my responsibilities while I am away. My team leader has approved my request (please find an approval letter from her attached). \n" +
                "\n" +
                "If you have any questions or concerns, I can be reached at my work email address or by phone. While I am away, I will not be able to check my email regularly, but I can be reached at my cell phone number if urgently needed. \n" +
                "\n" +
                "Thank you for considering my request. \n" +
                "\n" +
                "Best, \n" +
                "[Your Name]\n" +
                "[work email address]\n" +
                "[phone number]");
        data14.put("Title", "Draft");
        data14.put("Format", "Default Draft");
        data14.put("Topic", "Request PTO");
        templates.document("p8").set(data14);

//---------------------------------------------------------------------------------------------
        // Organization

        Map<String, Object> data15 = new HashMap<>();
        data15.put("Category", "Profession");
        data15.put("Draft", "Hi [Speaker's name]\n" +
                "\n" +
                "\n" +
                "I hope this message finds you well. \n" +
                "\n" +
                "We are honored to invite you to be the guest speaker at [event name]. \n" +
                "\n" +
                "Our event is to be held on [date] at the [venue] in [location]. We know that you are a terrific speaker and our attendees and delegates will gain much from your talk on[subject/theme/charity group].\n" +
                "\n" +
                "Please let us know soon if you are able to attend! We look forward to hearing from you!\n" +
                "\n" +
                "Best,\n" +
                "[company/school/organization name]");
        data15.put("Title", "Draft");
        data15.put("Format", "Default Draft");
        data15.put("Topic", "Speaker Invitation");
        templates.document("o1").set(data15);

        Map<String, Object> data16 = new HashMap<>();
        data16.put("Category", "Profession");
        data16.put("Draft", "Dear [sponsor’s name], \n" +
                "\n" +
                "My name is [name], and I am the [position] of [nonprofit’s name]. [Short description of orginzation, especially if you are not well known.] We work hard to raise money and help bring awareness to [cause]. \n" +
                "\n" +
                "In an effort to solve some of these challenges, we’re organizing [event, project, or campaign] to raise funds. We are so proud of what we’ve already achieved, but we want to continue making a greater contribution. With the costs of [various costs], we need the support of generous [businesses or donors] like you to get our project off the ground. \n" +
                "\n" +
                "I’m writing to ask you to sponsor [part of your event that needs sponsorship]. With [dollar amount], we’ll be able to [insert goal or achievement]. \n" +
                "\n" +
                "To discuss our project and how you can get involved, please give us a call at [phone number]. \n" +
                "\n" +
                "I hope to hear from you soon. Thank you in advance for your generosity. \n" +
                "\n" +
                "Sincerely, [name] \n" +
                "[phone number] \n" +
                "[email]");
        data16.put("Title", "Draft");
        data16.put("Format", "Default Draft");
        data16.put("Topic", "Request Sponsorship");
        templates.document("o2").set(data16);


        Map<String, Object> data17 = new HashMap<>();
        data17.put("Category", "Profession");
        data17.put("Draft", "Hello Everyone!\n" +
                "\n" +
                "This week will be having [name of the event] on [date and time] at [place of the event].\n" +
                "\n" +
                "[describe information about what the event is and a small itinerary].\n" +
                "\n" +
                "We are looking for volunteers to help set up the event. [describe what will be provided for the volunteers - food/water/stipend].\n" +
                "\n" +
                "Please fill out the form below if you are interested! The deadline to apply is [date of deadline].\n" +
                "\n" +
                "Looking forward to seeing you!\n" +
                "\n" +
                "All the best,\n" +
                "[Organization Name]\n");
        data17.put("Title", "Draft");
        data17.put("Format", "Default Draft");
        data17.put("Topic", "Event Volunteering");
        templates.document("o3").set(data17);






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