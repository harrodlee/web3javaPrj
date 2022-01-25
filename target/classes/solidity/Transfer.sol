pragma solidity ^0.6.0;


contract Transfer{
    address[] list = [0xDa9d14072Ef2262c64240Da3A93fea2279253611
    ,0xe579156f9dEcc4134B5E3A30a24Ac46BB8B01281
    ,0x533367b864D9b9AA59D0DCB6554DF0C89feEF1fF
    ,0x3e33590013B24bf21D4cCca3a965eA10e570D5B2
    ,0x09973e7e3914EB5BA69C7c025F30ab9446e3e4e0
    ,0xDF950cEcF33E64176ada5dD733E170a56d11478E
    ,0x72F8fa5da80dc6E20E00d02724cf05ebD302C35F
    ,0xf6a0Dc1fD1d2c0122ab075d7ef93aD79F02CcB93
    ,0xd616388f6533B6f1c31968a305FbEE1727F55850
    ,0x24639bE8F95f0A37457188F32668b3eE211325f0
    ,0x71D685EA395b336142D2Eec0234B63F47D98eC8b
    ,0x998B66fb675c1D267f80Ae08d6618Bc8b97C4715
    ];

    address owner;

    constructor() public {
        owner = msg.sender;
    }

    function transOwner(address addr) public{
        require (owner==msg.sender,"must be owner");
        owner = addr;
    }

    event aaa(uint256 indexed);

    function operate(address[] memory toList) public{
        require (owner==msg.sender,"must be owner");
        for(uint256 i = 0;i<list.length;i++){
            emit aaa(i);
            for(uint256 j = 0; j< toList.length;j++){
                IERC20 erc20 = IERC20(list[i]);
                erc20.transfer(toList[j],100000000000);
            }
        }
    }
}



/**
 * @dev Interface of the ERC20 standard as defined in the EIP.
 */
interface IERC20 {
    function transfer(address recipient, uint256 amount) external returns (bool);
}