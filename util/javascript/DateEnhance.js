Date.prototype.getMinutesOfDay = function(){
    return this.getHours()*60+this.getMinutes();
};
Date.prototype.getSecondsOfDay = function(){
    return this.getMinutesOfDay()*60+this.getSeconds();
};
Date.prototype.getMillisecondsOfDay = function(){
    return this.getSecondsOfDay()*1000+this.getMilliseconds();
};

Date.prototype.getSecondsOfHour = function(){
    return this.getMinutes()*60+this.getSeconds();
};
Date.prototype.getMillisecondsOfHour = function(){
    return this.getSecondsOfHour()*1000+this.getMilliseconds();
};

Date.prototype.getMillisecondsOfMinute = function(){
    return this.getSeconds()*1000+this.getMilliseconds();
};