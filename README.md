## MONOCHROME

This is my second major personal project, with the first being my [discordRPG](https://github.com/ShilohBeeler/discordRPG) project from a couple years back. This project is intended to be a Visual Novel engine and front-end, developed fully in Java. This serves three purposes: First, it's a good representation of the work I've done across the past semester in Java. Secondly, it seems like a fun endeavor. And finally, I'd really like to be able to make short stories into a more engaging format, since I love to write.

# Details

As of now, MONOCHROME is in a very barebones state. It has basic GUI functionality, but nothing more. Here's what I hope to implement by the time this project is in at least the first major release state:

Dynamic text, image, and music "displaying" should be fully supported, using the .mono file format, which is essentially just plaintext that tells the MONOCHROME engine that it can be read as a game. For anything beyond simple text, one will have to use meta tags to represent what they want to happen. Here's the list of planned tags:

| Tag | Description | Example |
| --- | --- | --- |
| \<img> [b/f] image.png | The image tag will read from your game's images folder and display it as either a background or foreground image depending on your specification. | \<img> b city.png |
| \<mus> songname | The music tag will automatically look for your song's folder in the game's music folder, and will check automatically to see if it's a single loop or if it has an intro, and play it accordingly. | \<mus> outrun |
| \<load> scriptname | The load file allows you to indicate that the game should run from a different .mono script -- this allows you to easily break up the script into multiple files when writing it for ease of organization. | \<load> chapter2 |
| \<end> | This is necessary so as to indicate to the engine that the game is over. It will stay on the last line of text indefinitely. | \<end> |

Much of how the engine works is based around a strict file structure for each game. This is still in the works, but looks like follows:

> game folder  
> ---main.mono  
> ---images folder  
> ------image1.png  
> ------image2.png  
> ---scripts folder  
> ------scripts  
> ---music folder  
> ------song 1 folder  
> ---------intro.mp3  
> ---------loop.mp3  
> ------song 2 folder  
> ---------loop.mp3

The naming conventions allows easy access to your resources when writing the scripts, and for the music, allows songs with intros to be handled easily. The tradeoff, of course, is simply that the naming convention is necessary when creating your own game.

MONOCHROME is also planning to support save states by the first major release, of course.

Due to many of the stringent requirements of creating a game for MONOCHROME, a sister project is planned for after the first major release which would act as an easy game creator.
