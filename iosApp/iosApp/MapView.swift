//
//  MapView.swift
//  iosApp
//
//  Created by Jean francois dagnogo on 28/02/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import MapKit


func myMapViewFactory() -> UIViewController {
    let myMapView = MapView() // Instantiate the SwiftUI View
    return UIHostingController(rootView: myMapView) // Use the view to construct a ViewController
}

struct MapView : View {
    @State private var region = MKCoordinateRegion(
        center: CLLocationCoordinate2D(latitude: 51.507222, longitude: -0.1275),
        span: MKCoordinateSpan(latitudeDelta: 0.5, longitudeDelta: 0.5)
    )

    var body: some View {
        Map(coordinateRegion: $region)
    }
}

#Preview {
    MapView()
}
