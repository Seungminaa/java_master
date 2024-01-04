// array5.js

const ary = [12, 20, 2, 1, 100, 88]
ary.sort((a,b) => {
    //오름차순: -1, 내림차순: 1
    if(a < b){
        return -1;
    }else{
        return 1;
    }
});

const friend = [
    {name:"Hong" , age:12},
    {name:"Hwang" , age:111},
    {name:"Park" , age:2},
    {name:"Kim" , age:33}
]
friend.sort((a,b) => {
    if(a.age < b.age){
        return -1;
    }else{
        return 1;
    }
})

console.log(ary);
console.log(friend);