# talking_cats
My projects for Android Academy SPb 2018.
Just an entertainable sample of Android feachures.

Here are our homeworks for the course.

Tasks:

1. Create an app in Android studio wich says "Hello World"
--> Created an app wich begins with a splash screen.

2. Create an activity with user input and two buttons: one should start a new activity and display that input, second should open a post app to send the input via E-mail, giving a mail its subject automatically.
--> Done; created both portrait and landscape versions; also made the app display texts in two languages (RU, ENG) using @res/values.

3. Create an activity with the layout as shown here: https://raw.githubusercontent.com/Android-Academy-SPB/Lecture2-Exercise/master/images/img_1.jpg 
--> Done; buttons added to get to the activity from the other activities.

4. Create an activity with RecyclerView, showing a list of cat photos; pressing any photo in list plays the cat meow sound. Mind the portrait and landscape leyouts. 
--> Done; also added cat sounds on every button (just for fun).

5. Working with threads:
Create an activity with two buttons: for AsyncTask activity and for Threads activity. Add two more activities to open after any of the buttons is pressed. Each of the opening activities has three buttons: "Create", "Start", "Cancel" and a text field. Both perform the same operation, but the implementation is different. Upon execution, the task, on a worker thread (on the background) counts from 1 to 10. From each number it writes it to the TextView and then sleeps for 500 milliseconds. When it gets to the end of the count (if wasn’t cancelled) it writes “Done!”. AsyncTask Activity performs the above with an AsyncTask primitive. The Threads Activity performs the same thing with your implementation to AsyncTask, using Java threads and Handler to communicate with the Main Thread.
--> Done; added a floating action button on other activities to get to the threads chooser activity.
