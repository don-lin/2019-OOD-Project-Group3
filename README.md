## <center>Hotel Management System</center>
### About our team 
#### group member

| Name         | UCD ID | BJUT ID |
| ------------ | ------ | ------- |
| Chen Donglin |16206515| 16372229|
| Yu Jiayue    |17206173| 17372203|
| Wang Xingren |17205963|17372212 |
| Xing Yang    |17206144|17372221 |
### Description

<hr>
This is a manage system for a small hotel. The main functions are add a new room, remove an exist room and change the room status.


<h2>Design patterns that we use:</h2>
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