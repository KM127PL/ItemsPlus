# ItemsPlus 

[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com) 
[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com) 
[![forthebadge](https://forthebadge.com/images/badges/it-works-why.svg)](https://forthebadge.com) 

This is just a  test plugin to **have fun** with [YAML](https://yaml.org/) in [spigot 1.16.3](https://spigotmc.org).

Its also using [Maven](https://maven.apache.org/).

To build you will need [Gradle](https://gradle.org/), and then run 
```jshelllanguage
$ ./gradlew package
```

Custom Item example:

```yaml
name: CUSTOM_SWORD #REQUIRED. id of the item ex. custom_sword
item: DIAMOND_SWORD #REQUIRED. name of the vanilla item you want to use ex. diamond_sword
display: &cSword of Stars #custom name of the item, supports color codes
```