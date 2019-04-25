/*
 * @lc app=leetcode id=242 lang=javascript
 *
 * [242] Valid Anagram
 */
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */

//object good
var isAnagram = function(s, t) {
	let s_ob = {};
	let t_ob = {};

	for (var i = 0; i < s.length; ++i) {
		s_ob[s[i]] = s_ob[s[i]] + 1 || 1;
	}

	for (var i = 0; i < t.length; ++i) {
		t_ob[t[i]] = t_ob[t[i]] + 1 || 1;
	}

	//length not same
	if (
		s.length !== t.length ||
		Object.keys(s_ob).length !== Object.keys(t_ob).length
	)
		return false;

	for (var i = 0; i < t.length; ++i) {
		if (s_ob[t[i]] !== t_ob[t[i]]) return false;
	}

	return true;
};

//sort and compare
var isAnagram = function(s, t) {
	if (s.length !== t.length) return false;
	var news = [...s].sort((a, b) => {
		return a.charCodeAt(0) - b.charCodeAt(0);
	});

	var newt = [...t].sort((a, b) => {
		return a.charCodeAt(0) - b.charCodeAt(0);
	});

	if (news.length !== newt.length) return false;

	for (let i = 0; i < news.length; i++) {
		if (news[i] != newt[i]) return false;
	}

	return true;
};
