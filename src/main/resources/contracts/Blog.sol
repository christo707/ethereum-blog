pragma solidity 0.5.10;
//pragma experimental ABIEncoderV2;

contract Blogs {
    
    uint public totalBlogs;
    
    mapping(uint => Blog) public blogs;
    
    enum Reactions {LIKE,HAHA,SAD,ANGRY,LOVE,WOW}
    
    struct Blog{
        uint blogid;
        uint createdTime;
        address writer;
        string title;
        string typeOf;
        string blog;
        uint totalReactions;
        uint totalComments;
        mapping(uint => React) reactions;
        mapping(uint => Comment) comments;
    }
    
    struct React{
        address givenBy;
        uint createdTime;
        Reactions reaction;
    }
    
    struct Comment{
        address givenBy;
        uint createdTime;
        string comment;
    }
    
    function addBlog (string memory _title,string memory _typeOf, string memory _blog ) public {
        totalBlogs++;
        blogs[totalBlogs] = Blog({
            blogid: totalBlogs,
            createdTime: now,
            writer: msg.sender,
            title: _title,
            typeOf: _typeOf,
            blog: _blog,
            totalReactions: 0,
            totalComments: 0
        });
    }
    
    function addReaction(uint  _blogid, uint  _reaction) public {
        (blogs[_blogid]).reactions[blogs[_blogid].totalReactions + 1] = React(msg.sender, now, Reactions(_reaction));
        blogs[_blogid].totalReactions ++;
    }
    
    function addComment(uint  _blogid, string memory _comment) public{
        (blogs[_blogid]).comments[blogs[_blogid].totalComments + 1] = Comment(msg.sender, now, _comment);
        blogs[_blogid].totalComments++;
    }
    
    function getComment(uint _blogid, uint _commentid) public view returns(string memory){
        return ((blogs[_blogid]).comments[_commentid]).comment;
    }
    
    function getReaction(uint _blogid, uint _reactid) public view returns(uint){
        return uint(((blogs[_blogid]).reactions[_reactid]).reaction);
    }
    
    function getCommentOwner(uint _blogid, uint _commentid) public view returns(address){
        return ((blogs[_blogid]).comments[_commentid]).givenBy;
    }
    
    function getReactionOwner(uint _blogid, uint _reactid) public view returns(address){
        return ((blogs[_blogid]).reactions[_reactid]).givenBy;
    }
    
    function getCommentTime(uint _blogid, uint _commentid) public view returns(uint){
        return ((blogs[_blogid]).comments[_commentid]).createdTime;
    }
    
    function getReactionTime(uint _blogid, uint _reactid) public view returns(uint){
        return ((blogs[_blogid]).reactions[_reactid]).createdTime;
    }
    
    
}