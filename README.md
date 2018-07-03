# LinkedIn clone

## About

This is a **Web Development** project, developed at the **Spring of 2018** by Kamaras Georgios and Triantafyllou Leonidas as a part of their university's **Web Applications Technologies** course. It is essentially a LinkedIn clone template.

## KNN details

Our application includes a _basic recommendation system_ with a goal of bringing to the user the articles and the job listings that might interest him the most. This recommendation system is build around the K-Nearest Neighbors (KNN) algorithm. What our algorithm basically does is that for each user it can fetch per request the articles and the job listings that might interest him the most from users that are either connected to him or not. So, the algorithm start by creating four similarity maps between users, based on the user connections that they have in common (their network), the commented articles, the liked articles and the liked job listings that they have in common. Then it sums up these four different similarity degrees between the users to one total similarity degree. In this process all the different similarity degrees have the same weight, but this can change (= 1), depending on where we want our KNN to emphasize. Based on the total similarity degree, the KNN picks up the N Nearest Neighbors-Users for each user. In the end, we pass to the user article and job listings from these N users.

## Contact & Feedback

* Kamaras Georgios: <sdi1400058@di.uoa.gr>
* Triantafyllou Leonidas: <sdi1400202@di.uoa.gr>
