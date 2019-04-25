var expect = require("chai").expect;
var describe = require("mocha").describe;
var temp = 3.6;
var test = function() {
	return 1;
};

describe("加法函数的测试", function() {
	it("1 加 1 应该等于 2", function() {
		expect(test()).to.be.equal(1);
	});
});
