# How Does Browser Work?
## What is Browser?
A browser is a software application used to locate, retrieve and display content on the World Wide Web, including Web pages, images, video and other files.
A browser is a group of structured codes which together performs a series of tasks to display a web page on the screen. According to the tasks they perform, these codes are made as different components.
## How it works?
 As a client/server model, the browser is the client run on a computer that contacts the Web server and requests information. The Web server sends the information back to the Web browser which displays the results on the computer or other Internet-enabled device that supports a browser.
## Architecture of Web Browser
![alt text](https://github.com/mrehanali127/Rehan_FYP/blob/main/Week2/architecture_of_browser.PNG)
## User Interface
The user interface is the space where User interacts with the browser. It includes the address bar, back and next buttons, home button, refresh and stop, bookmark option, etc. Every other part, except the window where requested web page is displayed, comes under it.
## Browser Engine
The browser engine works as a bridge between the
 User interface and the rendering engine. According to the inputs from
 various user interfaces, it queries and manipulates the rendering engine.
## Rendering Engine
The Rendering Engine is responsible for displaying the content of the
 web page on the screen. The primary operation of a Rendering engine is to parse HTML. By default, it displays HTML, XML, and images and supports other data types via plugin or extension.
The basic task of an engine is to convert the resources such as HTML documents of the webpage into a visual representation that a user find interactive.
Rendering Engine for modern web Browsers:
<li>Firefox — Gecko Software</li>
<li>Safari — WebKit</li>
<li>Chrome, Opera (15 onwards) — Blink</li>
<li>Internet Explorer — Trident</li>

 #### -> Trident
Trident engine was first seen with Internet Explorer 4.0 and due to its remarkable performance, it has been used in full-fledged today. This engine has been exclusively designed for the Windows Operating System and developed by Microsoft. Especially for software developers which would ease the web browsing functionality within the Windows Operating System. Besides, Trident has been used as an engine in web browsers(Internet Explorer). It has also got its applications in software that has direct integration with web browsing like as Google Chrome Browser, Maxthon etc.
#### -> Blink
Blink engine is used in the most popular web browser that is Google Chrome. It is developed as part of the Chromium project with contributions from Google, Opera Software and Adobe. Initially, the Blink engine was used on Google Chrome and Chromium browsers. However recently Blink engine is gaining more popularity, it is been used on Microsoft Edge, Opera Browser, Avast Secure Browser.
#### -> Gecko
Gecko engine is developed by Mozilla and It is used in the Firefox browser. And the fact it Gecko engine is an open-source software project. That makes the developers drive into its further development.
#### -> Webkit
It has a major contribution to Apple, Nokia, and WebKit foundation as well as other industries.
Recently Google came with Chrome browser that features WebKit engine as is used in the Android mobile phone for the first time in Google Chrome version.
It has been this recently that WebKit has been seen in any Android version, however, it has a good amount of contribution in Apples iPhone, iPod and is responsible to render content and email software within the web browser.

## JS Engine
The JS engine begins parsing the code right away after fetching from the server feeding into the JS parser. It converts them into the representative object the machine understands. The object that stores all the parser information in the tree representation of the abstract syntactic structure is called an object syntax tree (AST). The objects are fed into an interpreter which translates those objects into byte code.
These are Just In Time (JITs) compiler meaning JavaScript files downloaded from the server is compiled in real-time on the client’s computer. The interpreter and compiler are combined. The interpreter executes source code almost immediately; the compiler generates machine code which the client system executes directly.
Different Browser uses different JS Engine:
<li>Chrome — V8 (JavaScript engine) (Node JS was built on top of this)</li>
<li>Mozilla — SpiderMonkey (formerly known as ‘Squirrel Fish’)</li>
<li>Microsoft Edge — Chakra</li>
<li>Safari — JavaScriptCore / Nitro WebKit</li>

# Different Web Browsers
The web browser is an application that provides access to the webserver, sends a network request to URL, obtain resources, and interactively represent them. Common Browsers today include Firefox, Google Chrome, Safari, Internet Explorer and Opera.
![alt text](https://miro.medium.com/max/1000/1*9hjgVPLRAuxEM_3spfkI5g.png)

### -> Internet Explorer
Internet Explorer (IE) is a product from software giant Microsoft. This is the most commonly used browser in the universe. This was introduced in 1995 along with Windows 95 launch and it has passed Netscape popularity in 1998.
### -> Chrome
This web browser is developed by Google and its beta version was first released on September 2, 2008 for Microsoft Windows. Today, chrome is known to be one of the most popular web browser with its global share of more than 50%. Google Chrome is the most popular browser that people use today. The main reason for this is its speed. It’s a fast browser. It opens quickly and loads multiple tabs and pages in just one click. It’s probably the fastest browser available today. If you’re tired of waiting for your browser to open after clicking on its icon, you should switch to Chrome.
### -> Firefox
Firefox is a new browser derived from Mozilla. It was released in 2004 and has grown to be the second most popular browser on the Internet. The new Firefox consumes less RAM than Chrome and is faster than its previous versions. But there’s one problem with Firefox – it drains battery very quickly. So if you’re on a laptop, watching HD videos, it’s best to use Edge instead of Firefox because Firefox will eat up that battery in no time.
### -> Safari
Safari is a web browser developed by Apple Inc. and included in Mac OS X. It was first released as a public beta in January 2003. Safari has very good support for latest technologies like XHTML, CSS2 etc. Safari is a simple and clean browser with several features that make it a popular choice. It offers all the basic functionalities – the ability to open multiple tabs, easy bookmarking, fast speeds, and a plugin library. 
While Safari is mostly used on Mac, it can also be used on a PC. But on PC, Safari will be like just another browser. However, if you use Mac and iPhones, you’ll love the cross-platform compatibility that it offers. You’ll be able to integrate your data across multiple platforms if you use Safari. 

# How HTML, CSS and JS work together?
For Web development these three are main technologies which are main building blocks for any kind of web development. One is HTML, Second is CSS and last one is Javascript.
This corresponds to the three different types of files
 that you can use in your first website.<br>
An HTML file contains the structure of the page itself.
 It is kind of like the structure of the building.<br>
A CSS file contains the styling of the page.
 It allows you to change colors, positioning and more.
 It is kind of like the design of the building itself.<br>
A JavaScript file determines the dynamic and interactive
 elements on the page. It determines what happens
 when users click, hover, or type within certain elements.
 This is kind of like the functionality of the building.<br>
 ![Web Page](https://miro.medium.com/max/700/1*5GAPClpa09DmNcCslMA23Q.png)
 
 Let’s take the example from real world like houses in big cities. For example, A house has two bedrooms,
 two bathrooms, and two stories. That is the HTML of the building.
It is made of brick and has a solid wood door.
 That corresponds to the CSS of the building.
What can you do within the house? You can eat, sleep,
 make meals… anything that you do at home, really!
 That is the JavaScript of the building.
 ![House](https://miro.medium.com/max/700/1*3GaOb3tSGoZe4DjTZg9VXQ.png)
 
 ## How they work together?
 Here’s how they work together. HTML tags create objects; CSS properties design that object; JavaScript lets you manipulate those objects.
 For example, you use the HTML and tags to create a Web page, or document. To design webpage, CSS will be used, after that document is created, you can interact with it by using JavaScript.<br>
 The browser knows how to interpret the three different technologies. HTML marks up content according to different structural types like paragraphs, lists, blocks, images, tables, forms, comments, etc. CSS is used to tell the browser how the each type of element will be displayed. The way elements will be displayed may vary according to media, screen, print and handheld device. JavaScript tells the browser how the web page must be changed in response to events that happen like clicking on something or when value is changed in form input.


## References
<li>https://medium.com/@monica1109/how-does-web-browsers-work-c95ad628a509</li>
<li>https://medium.com/@bibekshah09/how-do-web-browsers-work-1245d5b06c51</li>
<li>https://www.thecoderworld.com/types-of-browser-engines/</li>
<li>https://medium.com/free-code-camp/the-relationship-between-html-css-and-javascript-explained-by-building-a-city-a73a69c6343</li>

