# How Does Browser Work?
## What is Browser?
A browser is a software application used to locate, retrieve and display content on the World Wide Web, including Web pages, images, video and other files.
A browser is a group of structured codes which together performs a series of tasks to display a web page on the screen. According to the tasks they perform, these codes are made as different components.
## How it works?
 As a client/server model, the browser is the client run on a computer that contacts the Web server and requests information. The Web server sends the information back to the Web browser which displays the results on the computer or other Internet-enabled device that supports a browser.
## Architecture of Web Browser
![alt text](https://github.com/mrehanali127/Rehan_FYP/blob/main/Week2/architecture_of_browser.PNG)
### User Interface
The user interface is the space where User interacts with the browser. It includes the address bar, back and next buttons, home button, refresh and stop, bookmark option, etc. Every other part, except the window where requested web page is displayed, comes under it.
### Browser Engine
The browser engine works as a bridge between the
 User interface and the rendering engine. According to the inputs from
 various user interfaces, it queries and manipulates the rendering engine.
### Rendering Engine
The Rendering Engine is responsible for displaying the content of the
 web page on the screen. The primary operation of a Rendering engine is to parse HTML. By default, it displays HTML, XML, and images and supports other data types via plugin or extension.
The basic task of an engine is to convert the resources such as HTML documents of the webpage into a visual representation that a user find interactive.
Rendering Engine for modern web Browsers:
<li>Firefox — Gecko Software</li>
<li>Safari — WebKit</li>
<li>Chrome, Opera (15 onwards) — Blink</li>
<li>Internet Explorer — Trident</li>

### JS Engine
The JS engine begins parsing the code right away after fetching from the server feeding into the JS parser. It converts them into the representative object the machine understands. The object that stores all the parser information in the tree representation of the abstract syntactic structure is called an object syntax tree (AST). The objects are fed into an interpreter which translates those objects into byte code.
These are Just In Time (JITs) compiler meaning JavaScript files downloaded from the server is compiled in real-time on the client’s computer. The interpreter and compiler are combined. The interpreter executes source code almost immediately; the compiler generates machine code which the client system executes directly.
Different Browser uses different JS Engine:
<li>Chrome — V8 (JavaScript engine) (Node JS was built on top of this)</li>
<li>Mozilla — SpiderMonkey (formerly known as ‘Squirrel Fish’)</li>
<li>Microsoft Edge — Chakra</li>
<li>Safari — JavaScriptCore / Nitro WebKit</li>

## References
<li>https://medium.com/@monica1109/how-does-web-browsers-work-c95ad628a509</li>
<li>https://www.thecoderworld.com/types-of-browser-engines/</li>

