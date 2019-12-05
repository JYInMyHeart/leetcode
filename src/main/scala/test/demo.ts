interface Test{
    name:string;
    address:string;
}

let a = {name: "2",address:"s",a:""};
let b:Test;
b = a
interface Person {
    firstName: string;
    lastName: string
}

type Tree<T> = {
    value: T;
    left: Tree<T>;
    right: Tree<T>;
}

type LinkedList<T> = T & { next: LinkedList<T> };
var people: LinkedList<Person>;
var s = people.firstName;
var s = people.next.firstName;
var s = people.next.next.firstName;
var s = people.next.next.next.firstName;