public class Map {

   private Room entrance, kitchen, diningRoom, garage, bedRoom, office, bathRoom, hallWay, livingRoom, freedomRoom;


   // we need items'
   public void createMap() {
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
                YOU HAVE ENCOUNTERED AN ENEMY ORC!!                      |
                                                                         |
                You can attack or move back to the previous room.        |
                He will not let you pass unless he is defeated.          |     
                ---------------------------------------------------------|
                 """);
      freedomRoom = new Room("freedom", """
                |------------------------|
                | YOU HAVE ESCAPED       |
                | FREEDOM AWAITS YOU.    |   
                |------------------------|
                 """);


      //connect rooms with directions
      entrance.setNorth(freedomRoom);
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


      // Create and add weapons to rooms
      MeleeWeapon knife = new MeleeWeapon("knife", 10);
      kitchen.addItem(knife);

      MeleeWeapon hammer = new MeleeWeapon("hammer", 50);
      garage.addItem(hammer);

      MeleeWeapon axe = new MeleeWeapon("axe", 20);
      bathRoom.addItem(axe);

      MeleeWeapon sword = new MeleeWeapon("sword", 20);
      livingRoom.addItem(sword);

      RangedWeapon crossbow = new RangedWeapon("crossbow", 60, 1);
      garage.addItem(crossbow);

      // Create enemies and add them to rooms
      Enemy enemy1 = new Enemy("Orc", 50, new MeleeWeapon("sword", 20));
      livingRoom.addEnemy(enemy1);

      Enemy enemy2 = new Enemy("Masked man", 50, new MeleeWeapon("axe", 25));
      bathRoom.addEnemy(enemy2);

      //create Food objects and add them to rooms
      Food apple = new Food("apple", 30);
      kitchen.addFood(apple);

      Food pizza = new Food("pizza", 20);
      diningRoom.addFood(pizza);

      Food bread = new Food("bread", 30);
      hallWay.addFood(bread);

      Food orcsMeat = new Food("orcs meat", -30);
      livingRoom.addFood(orcsMeat);

      //create and add items to rooms
      Item noteEntrance = new Item("letter");
      entrance.addItem(noteEntrance);

      Item noteGarage = new Item("note");
      garage.addItem(noteGarage);

      Item deadBodyDiningroom = new Item("dead body     ");
      diningRoom.addItem(deadBodyDiningroom);

      Item deadBodyBathroom = new Item("dead body     ");
      bathRoom.addItem(deadBodyBathroom);

      Food appleee = new Food("apple", 10);
      hallWay.addFood(appleee);

      Item key = new Item ("key");
      bedRoom.addItem(key);

   }

   public Room getEntrance() {
      return entrance;
   }
}
