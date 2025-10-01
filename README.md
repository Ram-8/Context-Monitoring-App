Q1. Specifications to Health-Dev Framework :-

1. Overview of the App: 
    The goal of the Context Monitoring App is to help users keep track of their 10 symptoms, heart rate data and respiratory
rate data. we shall use kotlin and XML to develop this Android App. Target users might be people who want to track health data but do not have a smart watch.

2. Requirements for the User Interface (UI):

On the main screen, there are 2 button, "Record Health Data" and "Delete All Records."

- The Record Health Data when clicked takes us to another page/activity within the app that has 3 buttons, check hear rate, check respiratory rate and check symptoms. 
- Clicking on check heart rate should let the user upload a 45-second video with their finger over the camera and flash.
- Next, a button that says "Check Respiratory Rate" should let the user submit three CSV files that shows the acceleration of the x, y, and z axes of the user.
- Finally, a button that says "Check Symptoms" when clicked should take the user to the Symptoms screen, where all 10 symptoms are calculated.(nausea = findViewById<RatingBar>(R.id.rating_nausea).rating.toInt(), headache, diarrhea, soreThroat, fever, muscleAche, lossSmellTaste, cough, shortnessOfBreath , feelingTired , heartRate , respiratoryRate).
- The symptoms screen: 10 sliders from 0 to 5 that let users rate how bad their symptoms are.
- After that, a button that says "Save all Recorded Data", when clicked will save all the 12 enteries.

3. Inputs and Outputs:

Inputs: A video file(finger covering camera and flash) to find your heart rate and 3 CSV files (x, y, and z axes) for finding the respiratory rate and ten symptom ratings on a scale from 0 to 5

 4. Results(either as an activity within the app or in the data inspection(which i have did)):
- Show's the heart rate 
- Show's the respiratory rate 
- Saved information that included all 12 enteries (10 symptoms and 2 vitals)
- Ability to look at old records

 5. sensors and processing:
- Heart Rate Detection: I want the app to look at the video and find color changes that happen when the user's heart beats and based off of the reflections of red color from the user's veins, we should calculate the hear rate.
- Detecting the respiratory rate: The software needs to look at the acceleration data in the CSV files that will be uploaded by the user.
- Symptoms: The user enters them by using a star rating method.
- all this data is stored in the RoomDB (12 enteries, including all previously recorded data)

 6. Non- Functional Requirements:
- Performance: Uploading of files should be quick and even though the hear rate calculation takes time, it needs to be as minimal as possible.
- Usability: The software should be easy to use and intutive and be available to people who aren't tech savvy.
- Reliability: It should be able to tolerate bad file inputs without crashing.
- Privacy and Security: In the main page, a delete all recorded button data is to be set, which when clicked will delete all the data( even previously recorded data).

 7. Privacy and Permissions:
- Access to the camera/video file to check heart rate.
- Access to upload csv files to check respiratory rate. 
- The user's device will save all of their data locally and the entire data can be deleted with the click of a single button, which ensures privacy.

 8. Testing and Evaluation Criteria:
- The heart rate is appropriately computed, stored and shown -
- The respiratory rate is correctly taken from the CSV files, calculated, stored and shown.
- All the data is saved in the Room database without any problems/errors
- Able to see all recorded data even if the app is closed and reopened. And all data is deleted by clicking delete recorded data buttton.
- The UI works the same way every time and doesn't crash.

Q2. Giving Feedback, improving context sensing and giving model of the user using bHealthy:

- With the bHealthy application suite, we can give users useful feedback that makes them more aware of and involved in their health.
- I utilized RoomDB to save symptoms and heart & respiratory rate locally, but we can gain greater insights from this stored data by using bHealthy.
- The first step in the feedback system is to look at patterns over time.  The system checks to see if a user's condition is getting better, staying the same, or becoming worse every time they enter their symptoms and/or vital signs.  
- The software doesn't just save information, it sends timely warnings like “Your respiratory rate has been consistently high for the past three days”, which might help the user understand their problem and seeks medical attention. 
- This feedback loop makes sure that consumers not only keep track of their health but also know what such data’s actually mean. I also wish to include parts that give physiological input such that the app will leverage bHealthy's framework to make simple graphs and color coded warnings that show when a user's data is in a risk zone.  
- If, for example, the respiratory/ heart rate goes up in an unusual way, the user gets an alert and their emergency contacts can be notified and if the irregularity is minor then a simple exercise to lower stress can be shown to the user via a video.  
- This gives the app instant value and makes it more useful in real life, all this can be done because bHealthy can sense its surroundings.  Also due to this, the system starts to build a dynamic model of the user by adding contextual information to the raw symptom data, such the time of day, the person's physical activity(such as step count) and/or their environment (which can be acquired through sensors in their device).
- The software learns how each person's symptoms are related to their lifestyle patterns, this helps the model to constantly evolve. This evolving of the mode can be done via integrating AI into the app.  For instance, if your stress level goes up after staying up late, the app can use that information to provide you specific advise like, "Your symptom trend suggests lack of sleep may be affecting your wellbeing." 
- As time goes on, this dynamic model will learn from the user’s data and improve its accuracy in prediction and also improve the way it models the data of the user.  It not only records and displays data, but it also forecasts possible risk conditions and sends out early alerts using AI integration.  
- The system makes a novel context-aware health monitoring by merging saved local data with bHealthy's feedback systems. This new kind of monitoring is personal, adaptable, and helps people not only stay healthy over the long term but also helps predict random spikes or dips in their vitals.
- Giving encouraging feedback when symptoms get better, including alerts that celebrate improvement in baseline and peak heart rate.
- We can give lifestyle advice that links symptoms to daily activities, like reminding people to drink more water if they feel more tired than usual and have headaches.
- Letting users create their own health targets and see how they are doing compared to those goals and also telling them how to achieve the goal.
- Adding social mid kind of capabilities that let users choose to share their progress trends with family and friends.
- Using anomaly detection to let users know when their normal patterns are changing in strange ways, so that they can get help with health problems that come up quickly and randomly.
- Making cumulative wellness reports that show users a full picture of their health by showing weekly or monthly patterns.

Q3. My persepctive about mobile Computing:

- After finishing Project 1 and reading the Health-Dev and bHealthy papers, my view on mobile computing has changed a lot.  At first, I thought mobile computing was largely about app design, development, testing and deployment and learning how to use Kotlin, XML, and RoomDB to make interfaces, process inputs and manage storage. But  After doing the project and reading all this, I understood my perspective seemed too restricted and incomplete.

- Now, I think that mobile computing is more than just making apps; it's also about making intelligent, context-aware adaptive systems.  
 
- Project 1 taught me how to use Uri to get data from video files, CSVs to get respiration rate and ratings to get symptoms, and then how to store the data in a database on my computer.  
- The Health-Dev paper clarified more about these things, by showing me that mobile systems may be model-driven, meaning that specifications of UI, data, and context requirements can very much help create apps that are scalable, reliable, and privacy-aware.  This shows that mobile computing isn't only about programming but it's also about systematic design.

- The bHealthy study took it even farther by showing how data that is stored can be turned into feedback loops and dynamic user models.  It helped me comprehend that mobile computing can combine physiological input, context sensing, anomaly detection, and predictive modeling to make the app work better overall.  

- bHealthy can help do more than just keep track of symptoms. It can send timely alerts, gives lifestyle advice and send wellness reports.  This shows how mobile computing can help builds frameworks that change with the user's lifestyle and environment and evolve with them over time.

