## HorizontalTextBar

### Android module to add a Custom TextView in your app. The textview are vertical arranged in a horizontal scroll layout. This can can expand or collaspe


### Usage

#### Adding the module dependency in app/build.gradle

```
    dependencies {
        compile project(':horizontaltextbar')
    }
```

#### Creating a HorizontalTextBarList

```
    HorizontalTextBarList horizontalTextBarList = new HorizontalTextBarList();
```

#### Adding title in the list

```
    horizontalTextBarList.addTextBar(title);
```

#### Showing the list

```
    horizontalTextBarList.show();
```

#### Demo

<img src="https://github.com/Anwesh43/HorizontalTextBar/blob/master/screencast/HorizontalTextBar.gif" alt="screencast of demo" width="300px" height="500px">
