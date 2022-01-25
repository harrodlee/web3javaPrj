pragma solidity ^0.6.0;


contract Voting {

  mapping (bytes32 => uint8) public votes;
  bytes32[] public candidates;

  //声明事件Vote
  event Vote(address voter, bytes32 candidate);

  //初始化投票数据
  constructor(bytes32[]memory candidateNames ) public {
    candidates = candidateNames;
  }

  //获取票数
  function getVotesFor(bytes32 candidate) view public returns (uint8) {
    require(validCandidate(candidate));
    return votes[candidate];
  }

  //投票函数
  function voteFor(bytes32 candidate) public {
    require(validCandidate(candidate));
    votes[candidate]  += 1;
    //触发事件Vote
    emit Vote(msg.sender, candidate);
  }


  //验证投票人数据
  function validCandidate(bytes32 candidate) view public returns (bool) {
    for(uint i = 0; i < candidates.length; i++) {
      if (candidates[i] == candidate) {
        return true;
      }
    }
    return false;
   }
}
