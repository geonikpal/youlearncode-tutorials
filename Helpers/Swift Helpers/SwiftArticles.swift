//
//  SwiftArticles.swift
//
//
//  Created by  Dimitris Tasios on 11/7/22.
//

import Foundation

// MARK: mark headings
private enum HeaderLevels: Int {
    case h1 = 36
    case h2 = 30
    case h3 = 24
    case h4 = 18
    case h5 = 12
    case h6 = 6
}

private func makeDashes(level: HeaderLevels, forFront: Bool) -> String {
    var line = ""
    
    for _ in 0 ..< level.rawValue {
        line += "-"
    }
    
    if forFront {
        line.insert("\n", at: line.startIndex)
    } else {
        line.insert("\n", at: line.endIndex)
    }
    
    return line
}

private func markHeading(level: HeaderLevels, title: String) {
    print("\(makeDashes(level: level, forFront: true)) \(title) \(makeDashes(level: level, forFront: false))")
}

// MARK: public functions
public func markHeading1(title: String) {
    markHeading(level: .h1, title: title)
}

public func markHeading2(title: String) {
    markHeading(level: .h2, title: title)
}

public func markHeading3(title: String) {
    markHeading(level: .h3, title: title)
}

public func markHeading4(title: String) {
    markHeading(level: .h4, title: title)
}

public func markHeading5(title: String) {
    markHeading(level: .h5, title: title)
}

public func markHeading6(title: String) {
    markHeading(level: .h6, title: title)
}
