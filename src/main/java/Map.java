public class Map {

   private Room entrance, kitchen, diningRoom, garage, bedRoom, office, bathRoom, hallWay, livingRoom;

// we need items'
     public void createMap(){
        // Define rooms and their descriptions
        entrance = new Room("Entrance", """
        --------------------------------------------|
        As you step inside the entrance,                        |      
        a spine-tingling chill surrounds you.                   |     
        The entrance hall is dimly lit with cobwebs everywhere, |    
        creaky floors, and a lingering sense of fear.           |  
        Your adventure into darkness has begun                  |  
        --------------------------------------------------------|
        """);
        kitchen = new Room("Kitchen", """
       --------------------------------------------|            
       Entering the kitchen, you feel another chilling gust of  |   
       air. It's a gloomy sight, with cracked, stained tiles on |    
       the floor, a flickering, broken chandelier, and shadows  |       
       dancing on rusty pots and pans. The air carries a        |        
       sickly-sweet odor, remnants of forgotten meals.          |       
       The sink drips rhythmically, like a ghostly heartbeat.   |        
       The room holds an unsettling atmosphere,                 |      
       and your adventure into the unknown continues.           |         
       ---------------------------------------------------------|
        """);
        diningRoom = new Room("Dining Room", """
       --------------------------------------------|               
       Stepping into the dining room, the atmosphere remains    |      
       eerie. Dim light reveals a table covered in dust,        |       
       frozen in time. Cobwebs hang like spectral drapes,       |      
       and the air is heavy with the echoes of past meals.      |         
       ---------------------------------------------------------|
        """);
        garage = new Room("Garage", """
       --------------------------------------------|
       In the garage, shadows play on rusted tools and          |  
       forgotten machinery. The air is thick with the           |    
       cent of oil and decay, and the silence is broken         |     
       only by the occasional drip from a leaky ceiling.        |         
       ---------------------------------------------------------|
        """);
        bedRoom = new Room("Bedroom", """
       --------------------------------------------|
       In the bedroom, a heavy sense of sorrow hangs in the air.| 
       The bed is unmade, and the room is in disarray.          | 
       The window curtains sway as if in mourning,              |     
       and the room is filled with a haunting stillness.        |         
       ---------------------------------------------------------|
        """);
        office = new Room("Office", """
       --------------------------------------------|
       The office is a haunting scene, with dusty,              |
       neglected papers strewn about. A broken desk chair       |  
       sits motionless, and the dim light barely illuminates    |   
       the unsettling stillness that lingers in the room.       |         
       ---------------------------------------------------------|
        """);
        bathRoom = new Room("Bathroom", """
       --------------------------------------------|
       The bathroom offers no respite from the foreboding.      |   
       Cracked tiles and a shattered mirror reflect a           |    
       grim picture. The faucet drips incessantly,              |   
       and the room feels cold and unwelcoming.                 |          
       ---------------------------------------------------------|
        """);
        hallWay = new Room("Hallway", """
       --------------------------------------------|
       As you move through the hallway, the walls seem to       |
       close in on you. The faded wallpaper is peeling,         |     
       and the floorboards creak beneath your feet.             |   
       Shadows seem to shift and whisper in the corners.        |          
       ---------------------------------------------------------|
        """);
        livingRoom = new Room("Living Room", """
       --------------------------------------------|
       Entering the living room, you're greeted by tattered     |
       furniture and an air of desolation. The remains of a     |    
       once-warm fireplace now stand cold and lifeless.         |     
       The room seems to hold memories of forgotten laughter.   |          
       ---------------------------------------------------------|
        """);

        // Connect rooms with directions


        entrance.setEast(kitchen);
        entrance.setSouth(garage);

        kitchen.setWest(entrance);
        kitchen.setEast(diningRoom);

        diningRoom.setWest(kitchen);
        diningRoom.setSouth(office);

        garage.setNorth(entrance);
        garage.setSouth(bathRoom);

        bedRoom.setSouth(hallWay);

        office.setNorth(diningRoom);
        office.setSouth(livingRoom);

        bathRoom.setNorth(garage);
        bathRoom.setEast(hallWay);

        hallWay.setNorth(bedRoom);
        hallWay.setWest(bathRoom);
        hallWay.setEast(livingRoom);

        livingRoom.setNorth(office);
        livingRoom.setWest(hallWay);


// Create and add items to rooms
        Item knife = new Item("knife", "Big Fat Juicy Looking Knife With Sweeping Egde III and Looting III");
        kitchen.addItem(knife);

        Item hammer = new Item("hammer", "Useful weapon");
        garage.addItem(hammer);
    }


   public Room getEntrance() {
      return entrance;
   }

   public void setEntrance(Room entrance) {
      this.entrance = entrance;
   }

   public Room getKitchen() {
      return kitchen;
   }

   public void setKitchen(Room kitchen) {
      this.kitchen = kitchen;
   }

   public Room getDiningRoom() {
      return diningRoom;
   }

   public void setDiningRoom(Room diningRoom) {
      this.diningRoom = diningRoom;
   }

   public Room getGarage() {
      return garage;
   }

   public void setGarage(Room garage) {
      this.garage = garage;
   }

   public Room getBedRoom() {
      return bedRoom;
   }

   public void setBedRoom(Room bedRoom) {
      this.bedRoom = bedRoom;
   }

   public Room getOffice() {
      return office;
   }

   public void setOffice(Room office) {
      this.office = office;
   }

   public Room getBathRoom() {
      return bathRoom;
   }

   public void setBathRoom(Room bathRoom) {
      this.bathRoom = bathRoom;
   }

   public Room getHallWay() {
      return hallWay;
   }

   public void setHallWay(Room hallWay) {
      this.hallWay = hallWay;
   }

   public Room getLivingRoom() {
      return livingRoom;
   }

   public void setLivingRoom(Room livingRoom) {
      this.livingRoom = livingRoom;
   }
}
