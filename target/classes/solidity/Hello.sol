pragma solidity ^0.6.0;
//import "remix_tests.sol"; // this import is automatically injected by Remix.
//import ".ballot.sol";

contract HelloWorld{
    string private strDemo="HelloWorld";
    function getStrDemo() public view returns(string memory){
        return strDemo;
    }
}
