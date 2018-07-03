# LinkedIn clone

## About

This is a **Web Development** project, developed at the **Spring of 2018** by Kamaras Georgios and Triantafyllou Leonidas as a part of their university's **Web Applications Technologies** course. It is essentially a LinkedIn clone template.

## Contact & Feedback

* Kamaras Georgios: <sdi1400058@di.uoa.gr>
* Triantafyllou Leonidas: <sdi1400202@di.uoa.gr>

## Project Details

-A linkedin clone created in eclipse.

-All requirements of exercise implemented(plus bonus - recommendation system with KNN algorithm)

-The project created following the MVC pattern, where the Model and Controller implemented in src directory and View in the WebContent directory.

-All the required libraries are included in the directory libraires of the project.

-A project created using Java, Html, Css, Javascript, JSTL(for the View in order not have Java code in jsp files):

-Used Tomcat 8

-SSL exists for https, listening to port 8443

## Password Hashing Details

Every time a user makes a sign-up request, the password given is hashed.

## XML Details

The admin of website has the ability to export in an XML file information for one or more users such as their personal info, their article and listings likes, their comments in articles, their skills and more.

## File System Upload Details

There is a file upload system in the project, so users can upload their photos, videos, audio files and curriculum vitae so other users can see.

## KNN details - Bonus

Our application includes a _basic recommendation system_ with a goal of bringing to the user the articles and the job listings that might interest him the most. This recommendation system is build around the K-Nearest Neighbors (KNN) algorithm. What our algorithm basically does is that for each user it can fetch per request the articles and the job listings that might interest him the most from users that are either connected to him or not. So, the algorithm start by creating four similarity maps between users, based on the user connections that they have in common (their network), the commented articles, the liked articles and the liked job listings that they have in common. Then it sums up these four different similarity degrees between the users to one total similarity degree. In this process all the different similarity degrees have the same weight, but this can change (= 1), depending on where we want our KNN to emphasize. Based on the total similarity degree, the KNN picks up the N Nearest Neighbors-Users for each user. In the end, we pass to the user article and job listings from these N users.
