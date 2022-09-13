var Pix = 500;
var Playing = true;
var Dices = new List<int>();
var LuckyNumber = 0;

var rnd = new Random();

while (Playing)
{
    var ContinueLoop = true;
    var betting = 0;
    Dices.Clear();

    while (ContinueLoop)
    {
        Console.WriteLine($"you have {Pix} pix left");
        Console.WriteLine("How much do you want to bet?");
        if (int.TryParse(Console.ReadLine(), out int bet))
        {
            if (bet >= 50 && bet <= Pix)
            {
                betting = bet;
                ContinueLoop = false;
            }
            else Console.WriteLine("Invalide Amount");
        }
        else Console.WriteLine("Bad input");
    }

    ContinueLoop = true;
    while (ContinueLoop)
    {
        Console.WriteLine("what is your lucky number between 1-6");
        if (int.TryParse(Console.ReadLine(), out int Number))
        {
            if (Number > 0 && Number < 7)
            {
                LuckyNumber = Number;
                ContinueLoop = false;
            }
            else Console.WriteLine("Number outside Range");
        }
        else Console.WriteLine("Bad Input");
    }

    Dices.Add(rnd.Next(7));
    Dices.Add(rnd.Next(7));
    Dices.Add(rnd.Next(7));

    var Corrects = 0;

    Console.WriteLine("Rolling");
    foreach (var dice in Dices)
    {
        if (dice == LuckyNumber) Corrects++;
        Console.WriteLine(dice);
    }

    Console.WriteLine($"You got {Corrects} Number Matching");
    Console.WriteLine();
    Pix += Corrects != 0 ? betting * (Corrects + 1) : 0;

    if (Pix < 50)
    {
        Console.WriteLine($"You got {Pix} pix left Game Over");
        Playing = false;
    }
    else
    {
        Console.WriteLine($"You got {Pix} pix. Do you want to continue (Y/N)");
        Playing = Console.ReadKey().Key == ConsoleKey.Y;
    }
}