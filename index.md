# Justin Aebi's Github ePortfolio

## Table of Contents
1. <a href="#PSA">Professional Self-Assessment<a>
2. <a href="#Code Review">Code Review<a>
3. <a href="#Thermostat">Thermostat Prototype<a>
4. <a href="#VS">Vector Sorting Program<a>
5. <a href="#App">Android Weight Tracking Application<a>
     		  - <a href="#App">App Download<a>

## 1. Professional Self-Assessment <a id="PSA"><a>
	
## 2. Code Review <a id="Code Review"><a>
	
Below is the video to my code review that I performed at the beginning of my journey to enhance each of the artifact choices where I provide an in-depth look at each of the programs, how they work, what issues there are, and what enhancements I believe I should make. If the link does not work for the embedded video [here is a link to the video itself on YouTube](https://www.youtube.com/embed/pC1tkp_Lheo).
  
  <p align="center">
    <iframe width="560" height="315" src="https://www.youtube.com/embed/pC1tkp_Lheo" title="Justin Aebi Code Review" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
  </p>

## 3. Thermostat Prototype <a id="Thermostat"><a>  

## What is it?
  
This is a demonstration of a thermostat prototype concept that I have been working on to demonstrate my skill in working with Embedded C and designing software. The thermostat utilizes a TI SimpleLink Wi-Fi CC3220S wireless microcontroller LaunchPad development kit to recreate a functional in-home thermostat. The software that I developed works with this device to allow it to read the current temperature of the room and will then turn on an LED to indicate that the heat is on when the room temperature falls below the set temperature as if to imitate the homes heating turning on. It then uploads the temperature data and elapsed time since the device was started every 1 second to imitate a read out of the temperature on a physical thermostat. This artifact was first created in April of 2022 during my CS-350 Emerging Systems Architectures and Technologies course, and later improved during my CS-499 Capstone course in September of 2022.
  
## Why did I choose to represent this item?
  
The reason for selecting this artifact for was to show my skills in working with Embedded C and to highlight my ability for software design. This was one of my better projects that I wanted to showcase as it incorporates not only my work with designing code, but also displays the functionality of the software on a physical device that could be used in modern homes. Originally the artifact showcased my skills in design as I developed a well written, communicative program that was easy to understand and begin using. It highlighted my ability to create a task scheduler that uses state machines that would operate with a timer to incorporate the functionality of the thermostat. It also demonstrates my ability to write code using tools and a language that I have never before used with little to no instruction.
	
Looking at the original project, it was not perfect and did have some flaws that needed to be addressed. Specifically, the explanation for the code was there, but not concise. The switch statements within the code lacked default cases, the timings felt slow, and there was no set temperature limit to the thermostat. I started with improving my comments and providing more explanation of the code itself. I then started implementing the changes by including the default cases to each switch statement. I began testing by manually triggering the default cases so I could verify functionality and the task scheduler kept working when it was supposed to fail so I had to make some adjustments there. Initially I attempted a few changes, but then looked at documentation on the timer to figure out how to correctly disable it. The resulting default cases were created to display an output message, turn off the LED sequence, disable the heating element and stop the timer from functioning leaving the thermostat in a paused state where nothing would function.
	
I then began working on adjusting the timings where I updated the frequency at which the button input was being read and increased how often the temperature was read. Lastly, I included some if statements to check if the temperature set point goes beyond 38 degrees Celsius or below 0 degrees Celsius. If the temperature does reach those point it will correct the temperature setpoint so that it cannot surpass these bounds. That was the only major security flaw to the device, and I wrote the code in such a way that it should provide the most efficient method to correcting the temperature set point based on my knowledge of how the data would be altered in binary from my learning in software reverse engineering.
  
## Reflection.
  
The choice of this artifact as a project to enhance was a great selection to start with in hindsight. It was enjoyable to see one of my favorite projects that I had previously created be enhanced. I learned a few things along the way and feel that it is now an even better project that I can showcase. When enhancing this artifact, I knew that some parts of the enhancement were not going to be simple. I had started with a plan for implementing all my features which would be included first. I wanted to address security and design flaws first. I had to think about how the best way was to approach the temperature limits. I wanted to implement it in a way that did not cause any more issues than was already present, but at the same time I did not want to write a bunch of code that looks messy to get the code functioning how it needed to. From this I learned that it is best to assess the problem, identify a solution and think on it before making decisions. I gave myself some time to think about how I would make the changes before implementing it and eventually had come up plan for it. 
	
When it came to the default cases that needed to be included for each of my state machines, I implemented some of the code, did some initial tests and found that it was not functioning how it should have. It was not stopping the program when it should have, but instead just kept outputting the same failure message. I knew that this meant the timer was still running. From this I learned and experienced exactly why it is so important to not only write the code, but consistently perform tests on the code as it is being developed. This is a very valuable lesson that has been taught by my courses, and for good reason. Though there were some minor setbacks, the challenges that were presented, and the ways in which I overcame them is one of the reasons why writing code can be so enjoyable for me. Overall, I think that this was a great project to learn from and one that I am happy to showcase.
  
### Enhancements Made
```
- Created set temperature upper and lower input limitations.
- Included default cases to prevent device from continuing to malfunction upon failure.
- Reworked state machine timings for temperature readings, and input detection.
- Reworked comments to be more concise and explanatory.
```
<sub>[Thermostat Prototype demonstration video link](https://youtube.com/shorts/xkgiWN-o8l4)</sub>

## 4. Vector Sorting Program <a id="VS"><a>
  
## What is it?
	
This artifact displays a menu that lists multiple options for sorting data from a csv file using three different vector sorting algorithms. It is designed to read data from a csv file in the same directory as the .exe file and will sort that data using one of multiple different sorting algorithms. The choice is from a selection sort which finds the minimum element from the unsorted part and puts it at the beginning, an insertion sort which virtually splits the vector into a sorted and unsorted part where values are picked from the unsorted part and put into the correct position in the sorted part, and a quick sort which partitions the data and picks a pivot point where it divides and conquers the sorting process. This artifact was first created in January of 2021 during my CS-260 Data Structures and Algorithms course, and later improved during my CS-499 Capstone course in September of 2022.
  
## Why did I choose to represent this item?
	
The choice behind this artifact was to showcase and test my ability to develop multiple sorting algorithms as both practice and a challenge to myself. This choice displays my parts of my knowledge of the C++ language and my ability to create sorting algorithms and apply them to vectors. This artifact shows my ability to build a project that is easy for other developer to look at and modify by providing supportive code comments and explanations as to how everything works and how to use it. It shows that I can design and develop a professional quality program that is both technically sound and provides coherent communication within the written code. I have also shown that I can maintain a security mindset and anticipate exploits in software through my implementation of secure code and by mitigating design flaws by providing backup cases if inputs are not correctly entered or if buffer overflows are attempted. I explain each of the different sorting algorithms time complexity and their best, average, and worst-case performance in terms of big O notation within the code. This program is a great example of how it can be utilized and implemented into professional and industry-based programs to automatically sort large or small data sets for companies. 
  
## Reflection.
	
Initially I knew that with this program being written in C++ was going to come with some difficulty with accepting inputs from a user without causing issues along the way. This was my first goal for problem solving in the code. I tested some ways of preventing endless loops with little success, but with some research I learned about some more C++ methods that would help fix the problem and managed to create a default case to clear the input buffer to fix the problem I was facing. This taught me that it is important to look at documentation and examples of code so I can learn more about the language and what methods to use to accomplish my tasks.
	
The next big challenge for me was to incorporate a new sorting algorithm. I looked at a few examples of sorting algorithms that are not the same as the ones already implemented and had difficulty getting them to work. The issue was I did not understand the added complexity that comes with sorting a vector over sorting an array. I tried to implement multiple algorithms but was coming to a stopping point at each one trying to understand how to access and change positions of the vector but had struggled. I had then tried to implement a different algorithm but was met with the same issues. I had to decide on one algorithm and investigate that without changing my choice. I settled on an insertion sort because it was one that I felt I could understand better than others in how it was to perform and stayed consistent in trying to implement that one only. After some trial and error, I was stumbling onto an error message that I didn’t understand. I knew that the insertion sort is possible with how I was implementing it and I was able to accomplish a sort of the data that was being read, but the sort was incorrect and jumbled. It appeared like it had no structure. I looked further into the error message and found some more information on it and why the sort wasn’t working properly. With that information I was able to find the solution and properly sort the data with no issue shortly after my findings.
	
What I learned from this artifact is that when I stumble into a problem in my code or something that is not working correctly, I need to stop trying to just test my way out of it by trying different things and take a moment to understand why it isn’t working and really investigate the root of the problem. This gave me the time to investigate the error messages I was seeing and research what they are trying to tell me. This was a much more effective way to problem solve. Sometimes breaks are necessary to get out of the rut that the mind can take you into because if I continue down the same path that is leading to errors or failure it only wastes time and energy. Walking away from the code for a bit helped me clear my thoughts and think without distraction about the code and how it should function. Overall, this artifact taught me a lot and how I need to think about my approaches differently to solving problematic code. Sometimes I get caught up into thinking how something is going to be easy for me because I excel at most things, when really, I need to get out of that mindset and truly problem solve by walking through the code and the functionality in my mind. By trying to understand it step by step I can problem solve much more effectively.
  
### Code Snippets
<img src="https://mishievouscloud.github.io/MischievousCloud.github.io/Images/InsertionSort.png" style="display: block; margin: auto;" />
	
### Enhancements Made
```
- Included additional sorting algorithm and menu option.
- Removed unused code.
- Included default cases that clear input buffer and prevent endless loop and overflows.
- Tested inputs for failure points and corrected any identified failure points.
- Fixed signedness issue in the code to remove errors.
- Reworked comments to provide more explanation for the code.
```

## 5. Android Weight Tracking Application <a id="App"><a>
  
## What is it?
	
This artifact is an Android Mobile application that is designed to allow the user to track their weight over time and provide them with an easy-to-use application that can record and display weight data. The user can enter a weights associated with specific days and a goal weight which when reached will congratulate the user upon achieving their goal. Dates and weight data can be updated and deleted from the database. It is designed and written from scratch in Android Studio using Java. This artifact was first created in April of 2021 during my CS-360 Mobile Architecture and Programming course, and later improved during my CS-499 Capstone course in October of 2022.
  
## Why did I choose to represent this item?
	
This artifact choice is a great example of my learning process with using SQLite databases and designing a mobile application from scratch. The reason for selecting this item is because it is a great example of my ability to problem solve and showcase the new skills I have acquired with using databases and developing and designing a mobile application. When I first developed the app I had a rather challenging time spending nearly every waking minute working on the features in order to have a worthy submission within a small time constraint. This artifact is a great choice for showing off my ability to take on a challenge and overcome it. Some of the components that best display my skills are with my ability to write code using an object-oriented programming language, write effective and informative comments within my code, utilize best practices with coding standards, and maintain a security mindset during development.
	
There were many issues that were unresolved within the first iteration of the application that have been addressed during the development of this artifact. Mainly the biggest issue with the application was that data was being displayed to the screen by all users rather than the current one logged in within the application. This was addressed as a flaw within the constraints of how the database was structured and the solution was to remove the login feature entirely and rework the database. This decision was also intended as a design choice as my intentions for the app were for it to be local and not require login features. Initially data was held in three databases and now there is only one database holding the information. The login screen was not necessary as this application was meant to be for an individual user and offline. Removing the unnecessary feature and reworking the database alleviated this problem. Another issue was with the update feature being entirely broken. It would indicate an update was successful to the data, but no data would change within the database. After much trial and error and plenty of research I was able to identify why this was occurring and since then has been corrected and now the update feature works to update the fields in the database.
	
The application also had many unused features. There was an SMS messaging system that was supposed to update the user to how close they were to reaching their goal, but this was unused and removed. This was not intended to be implemented in the original design but due to required parameters of the course outcome it was necessary to implement, but not to have functioning. There was also some unreachable code that was removed, and redundancies were also removed. The notifications feature which was functional but entirely unused was also removed as it was no longer relevant to the design decisions.
  
## Reflection.
  
This artifact was one of the more difficult projects I have ever worked on as mobile app development is was new to me. I have learned a lot from the time I have spent on this project. When enhancing this application, I had come across many errors that did not make sense to me and I took the time to really investigate each of the problems and try to understand why they had occurred. One issue with the database was trying to get the data to display per user. I had tried many different approaches but found that foreign key constraints might be the way to display data by only showing data entered by a specific id, however that ended up not working entirely because of how the data was split between databases and how fixing it was not possible with how things structured. This led to me having to alter some design decisions and come up with a solution to the problem. I settled on reworking the database, which I had done a few times to find the best setup and removed the login feature. The other big issue I was having was with the update functionality. It was not working at all before working on enhancing the artifact and after looking into the logs I found an error that was happening and found a solution. The way I was querying the dataset was not correct built and it would still indicate a success despite doing absolutely nothing, but with some time spent on that I was able to get the update feature working. 
	
One thing that helped during this development cycle was my process plan for working on this project. I had spent time working on an exact plan of attack for each failure point in the application and listed backup design decisions in case I could not correct it. I would spend as much time as I could getting research done and going through testing iterations to find solutions to my features and as soon as I felt my head was getting heavy from stress and confusion, I would take a break to alleviate this. Before each break I managed to make small progress at identifying why issues were occurring and how I could potentially get them to work, and I would spend the next iteration testing those potential changes and identifying new ones. In the end, throughout this development I had encountered numerous issues and faced many challenges, but from that I learned a lot about how the code functions, and I learned why it was working incorrectly in many cases. The experience from this was one of the most valuable in teaching me how to become a better programmer. I would not have had as much success in this project if I had not applied what I had learned from each of my other artifact choices and the challenges I faced in those.
	
### Screenshots
	
<img src="https://mishievouscloud.github.io/MischievousCloud.github.io/Images/HomeScreen.png" style="display: block; margin: auto;" />
<img src="https://mishievouscloud.github.io/MischievousCloud.github.io/Images/MainScreen.png" style="display: block; margin: auto;" />
<img src="https://mishievouscloud.github.io/MischievousCloud.github.io/Images/CalandarDialog.png" style="display: block; margin: auto;" />
<img src="https://mishievouscloud.github.io/MischievousCloud.github.io/Images/UpdateView.png" style="display: block; margin: auto;" />
<img src="https://mishievouscloud.github.io/MischievousCloud.github.io/Images/NavDrawer.png" style="display: block; margin: auto;" />


### App download: <a id="AppDownload"><a>
[MyWeight.apk](https://mishievouscloud.github.io/MischievousCloud.github.io/MyWeight.apk)

### Enhancements Made
```
- Fixed database issues.
- Removed unnecessary login feature.
- Removed unused notifications feature.
- Removed SMS messaging due to design decisions.
- Removed unused code, unreachable code, and redundancies.
- Addressed security concerns to the database.
- Fixed and properly implemented the update feature.
- Handled inputs and provided error messages to incorrect update inputs
- Fixed style issues on all pages regarding buttons, sizing, backgrounds, and overall layout
- Implemented goal feature with functional accomplishment toast.
- Reworked comments.
- Performed vairous testing on all aspects of the app to ensure proper functionality and usability.
- Added a better naming for project title, file names, and home screen title.
```
	
