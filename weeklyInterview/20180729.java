//How to get the degree between hour and min pointer? (Right bottom direction)

int getHourAsbDegree(int hour, int minute)
{
  return getHourAsbDegreeHourPart(hour) + getMinuteAbsDegree(minute);
}

int getHourAsbDegreeHourPart(int hour)
{
  return hour / 12 * 360;
}

int getMinuteAbsDegree(int minute)
{
  return minute / 60 * 360;
}

public int getDegree(int hour, int min){
  return Math.abs(getHourAsbDegree(hour, min) - getMinuteAbsDegree(min));
}
   Math.abs(25-300) = 275


Design, 设计时可以细分问题
Rookie mistake
Abstraction and simplify
