## <center>Hotel Management System</center>
### About our team &#x270C;
#### group member

| Name         | UCD ID | BJUT ID |
| ------------ | ------ | ------- |
| Chen Donglin |16206515| 16372229|
| Yu Jiayue    |17206173| 17372203|
| Wang Xingren |17205963|17372212 |
| Xing Yang    |17206144|17372221 |
### Description
<hr>
This is a manage system for a small hotel&#x1f600;. The main functions are add a new room, remove an exist room and change the room status.
<hr>
<h3>Requirements</h3>
<h5>To run this hotel manage system, you need:<h5>
<p>eclipse IDE  &#x2705;</p>
<p>jdk >= 1.8  &#x2705;</p>


asdfa`adsf`  dfas

<hr>
<h2>Design patterns  that we use:</h2>
<h3>1. The Observer Pattern:</h3>
<p>Class [DateManager](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/tree/master/04%20-%20Implementation/final%20project/src) manage the current date. When the date change, [DateManager](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/tree/master/04%20-%20Implementation/final%20project/src) will notify the [RoomMapper](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/tree/master/04%20-%20Implementation/final%20project/src) which generate a new room status list to match the date.
</p>

<h3>2. The Factory Method Pattern:</h3>
<p>[RoomMapper](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/tree/master/04%20-%20Implementation/final%20project/src) could produce new rooms object when a new date is selected.</p>

<h3>3. The Singleton Pattern:</h3>
<p>Class [getSelectedDate](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/tree/master/04%20-%20Implementation/final%20project/src) maintain the selected date. Only one instance in the whole system.</p>

<h3>4. The Iterator pattern:</h3>
<p>[RoomMapper](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/tree/master/04%20-%20Implementation/final%20project/src) get a rooms list and bookings list from the database. The mapper will traverse the container and generate a new rooms status list from the bookings.</p>

<h3>5. The Visitor pattern:</h3>
<p>Interface [PersistentBooking](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/tree/master/04%20-%20Implementation/final%20project/src) have a function called "getRoomNumber". Class [Booking](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/tree/master/04%20-%20Implementation/final%20project/src) extend that interface and implement that function.</p>

<h2>glossary</h2>

<strong>Booking(Reservation):</strong><br> An advanced reservation for a room at a particular date for a couple of days<br><br>
<strong>Customer:</strong><br> The person asking for hotel room booking<br><br>
<strong>Check-in:</strong><br> The arrival and living-in-hotel of the customer <br><br>
<strong>Check-out:</strong><br> The leaving of the hotel customer<br><br>
<strong>Walk-in:</strong><br> A check-in without a booking of the room<br><br>
<strong>Room-status:</strong><br> The current state of a room, can be already booked, already checked-in(paid) and available for booking<br><br>
<strong>Administrator(Manager):</strong><br> The person who manages the hotel database system with a login authority<br><br>
<strong>Staﬀ:</strong><br> The person who manages the booking request from the customer<br><br>
<strong>Room-type:</strong><br> The room with diﬀerent sizes and numbers of beds<br><br>
<strong>VIP:</strong><br> The status of a customer recorded in the hotel database<br><br>

<hr>
<h2>software instructions&#x1F4BB;</h2>
<h3>display all rooms status</h3>
![Image of Yaktocat](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/raw/master/04%20-%20Implementation/instruction/displayAllRoomStatus.png)
<h3>display available rooms status</h3>
![Image of Yaktocat](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/raw/master/04%20-%20Implementation/instruction/displayAvailableRoom.png)
<h3>display booked rooms status</h3>
![Image of Yaktocat](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/raw/master/04%20-%20Implementation/instruction/displayBookedRoom.png)
<h3>display checked rooms status</h3>
![Image of Yaktocat](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/raw/master/04%20-%20Implementation/instruction/displayCheckedRoom.png)
<h3>select a date</h3>
![Image of Yaktocat](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/raw/master/04%20-%20Implementation/instruction/selectADate.png)
<h3>sort by price</h3>
![Image of Yaktocat](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/raw/master/04%20-%20Implementation/instruction/sortByPrice.png)
<h3>sort by room number</h3>
![Image of Yaktocat](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/raw/master/04%20-%20Implementation/instruction/sortByRoomNumber.png)
<h3>sort by room type</h3>
![Image of Yaktocat](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/raw/master/04%20-%20Implementation/instruction/sortByType.png)



<h3>select a page</h3>
![Image of Yaktocat](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/raw/master/04%20-%20Implementation/instruction/selectAPage.png)
<h3>remove an existing room</h3>
![Image of Yaktocat](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/raw/master/04%20-%20Implementation/instruction/removeARoom.png)
<h3>modify price</h3>
![Image of Yaktocat](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/raw/master/04%20-%20Implementation/instruction/modifyPrice.png)
<h3>check in</h3>
![Image of Yaktocat](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/raw/master/04%20-%20Implementation/instruction/checkIn.png)
<h3>walk in</h3>
![Image of Yaktocat](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/raw/master/04%20-%20Implementation/instruction/walkIn.png)
<h3>add a new room</h3>
![Image of Yaktocat](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/raw/master/04%20-%20Implementation/instruction/addANewRoom.png)
<h3>add a booking</h3>
![Image of Yaktocat](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/raw/master/04%20-%20Implementation/instruction/addABooking.png)
<h3>cancel a booking</h3>
![Image of Yaktocat](https://csgitlab.ucd.ie/16206515/2019-ood-project-group3/raw/master/04%20-%20Implementation/instruction/cancelABooking.png)