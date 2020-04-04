int pin = 7;  
int data; 

int initialValue = 1;

void setup(){
  Serial.begin(9600);

  pinMode(pin, OUTPUT); 
}

void loop(){
  if(Serial.available() > 0){ 
      data = Serial.read();
      switch(data){
        case 1:
           digitalWrite(pin, HIGH);
        break;
        case 2:
           digitalWrite(pin, LOW); 
         break;
    }
  }
}