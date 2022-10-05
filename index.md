# GitHub Portfolio Collected Works
<sub>Original works and enhancements created by: Justin Aebi</sub>

## Table of Contents
1. <a href="#Thermostat">Thermostat Prototype<a>
2. <a href="#VS">Vector Sorting Program<a>
3. <a href="#App">Android Weight Tracking Application<a>
4. <a href="#Code Review">Code Review<a>
5. <a href="#PSA">Professional Self-Assessment<a>
  
## 1. Thermostat Prototype <a id="Thermostat"><a>
  
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

## 2. Vector Sorting Program <a id="VS"><a>
  
## What is it?
  
## Why did I choose to represent this item?
  
## Reflection.
  
### Code Snippets
<img src="https://mishievouscloud.github.io/MischievousCloud.github.io/Images/InsertionSort.png" style="display: block; margin: auto;" />
  
## 3. Android Weight Tracking Application <a id="App"><a>
  
## What is it?
  
## Why did I choose to represent this item?
  
## Reflection.
  
### Code Snippets/Screenshots
  
## 4. Code Review <a id="Code Review"><a>
	
Below is the video to my code review that I performed at the beginning of my journey to enhance each of the artifact choices where I provide an in-depth look at each of the programs, how they work, what issues there are, and what enhancements I believe I should make. If the link does not work for the embedded video [here is a link to the video itself on YouTube](https://www.youtube.com/embed/pC1tkp_Lheo).
  
  <p align="center">
    <iframe width="560" height="315" src="https://www.youtube.com/embed/pC1tkp_Lheo" title="Justin Aebi Code Review" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
  </p>
  
## 5. Professional Self-Assessment <a id="PSA"><a>
  
  Example text placeholder.
  
  Ignore everything below for now.
  
	
	
You can use the [editor on GitHub](https://github.com/MishievousCloud/MischievousCloud.github.io/edit/gh-pages/index.md) to maintain and preview the content for your website in Markdown files.

For more details see [Basic writing and formatting syntax](https://docs.github.com/en/github/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax).

### Jekyll Themes

Your Pages site will use the layout and styles from the Jekyll theme you have selected in your [repository settings](https://github.com/MishievousCloud/MischievousCloud.github.io/settings/pages). The name of this theme is saved in the Jekyll `_config.yml` configuration file.

### Support or Contact

Having trouble with Pages? Check out our [documentation](https://docs.github.com/categories/github-pages-basics/) or [contact support](https://support.github.com/contact) and we’ll help you sort it out.
Find me on <a href="https://www.linkedin.com/in/justin-aebi/">LinkedIn<a>.
